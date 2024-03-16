import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Scanner;

interface IPilha<T> {
    void empilhar(T elemento);

    T desempilhar() throws EmptyStackException;

    T topo() throws EmptyStackException;

    boolean estaVazia();
    void limpa();
    int tamanho();
}

class Nodo<T> {
    private Nodo<T> proximoNodo;
    private T elemento;

    public Nodo(T elemento) {
        this.elemento = elemento;
        this.proximoNodo = null;
    }

    public void setProximoNodo(Nodo<T> proximoNodo) {
        this.proximoNodo = proximoNodo;
    }

    public Nodo<T> getProximoNodo() {
        return proximoNodo;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
}

class ListaEncadeada<T> {
    protected Nodo<T> primeiro;
    protected Nodo<T> ultimo;
    protected int tamanho;

    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void limpa() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void removerEmPosicao(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        if (posicao == 0) {
            this.removerComeco();
            return;
        }
        if (posicao == this.tamanho - 1) {
            this.removerFinal();
            return;
        }
        Nodo<T> anteriorAoRemovido = this._getNodo(posicao - 1);
        Nodo<T> removido = anteriorAoRemovido.getProximoNodo();
        anteriorAoRemovido.setProximoNodo(removido.getProximoNodo());
        this.tamanho--;
    }

    public void removerComeco() {
        if (this.tamanho == 0) {
            throw new IllegalArgumentException("A lista esta vazia");
        }
        this.primeiro = this.primeiro.getProximoNodo();
        this.tamanho--;
    }

    public void removerFinal() {
        if (this.tamanho == 0) {
            throw new IllegalArgumentException("A lista esta vazia");
        }
        if (tamanho == 1) {
            this.primeiro = null;
            this.ultimo = null;
            this.tamanho--;
            return;
        }
        Nodo<T> penultimo = this._getNodo(tamanho - 2);
        this.ultimo = penultimo;
        penultimo.setProximoNodo(null);
        this.tamanho--;
    }

    public void adicionarEmPosicao(T elemento, int posicao) {
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        if (posicao == 0) {
            this.adicionarNoComeco(elemento);
            return;
        }
        if (posicao == this.tamanho) {
            this.adicionarNoFinal(elemento);
            return;
        }

        Nodo<T> novoNodo = new Nodo<T>(elemento);

        Nodo<T> antesDoNovo = this._getNodo(posicao - 1); // pegar o que vai ficar antes dele
        novoNodo.setProximoNodo(antesDoNovo.getProximoNodo());
        antesDoNovo.setProximoNodo(novoNodo);
        this.tamanho++;
    }

    public void adicionarNoFinal(T elemento) {
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if (this.tamanho == 0) {
            this.primeiro = novoNodo;
            this.ultimo = novoNodo;
        } else {

            this.ultimo.setProximoNodo(novoNodo);
            this.ultimo = novoNodo;

        }
        this.tamanho++;
    }

    public void adicionarNoComeco(T elemento) {
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        //
        // [] -> [] -> [] -> []
        //
        // prim ultimo
        //
        if (tamanho == 0) {
            this.primeiro = novoNodo;
            this.ultimo = novoNodo;
        } else {
            novoNodo.setProximoNodo(this.primeiro);
            this.primeiro = novoNodo;
        }

        tamanho++;
    }

    public T get(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximoNodo();
        }
        return atual.getElemento();
    }

    public int indiceDe(T elemento) {

        if (this.tamanho == 0) {
            return -1;
        }
        int indice = 0;
        Nodo<T> atual = this.primeiro;
        while (atual != null) {
            if (atual.getElemento() == elemento) {
                return indice;
            }
            atual = atual.getProximoNodo();
            indice++;
        }
        return -1;

    }

    public static void ordena(ListaEncadeada<Integer> lista) {
        for (int i = 0; i < lista.tamanho(); i++) {
            for (int j = 0; j < lista.tamanho() - 1; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    int auxiliar = lista.get(j + 1);
                    lista.set(lista.get(j), j + 1);
                    lista.set(auxiliar, j);
                }
            }
        }
    }

    private Nodo<T> _getNodo(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximoNodo();
        }
        return atual;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("[");

        Nodo<T> atual = this.primeiro;

        while (atual != null) {
            s.append(atual.getElemento());
            if (atual.getProximoNodo() != null) {

                s.append(", ");
            }
            atual = atual.getProximoNodo();
        }
        s.append("]");

        return s.toString();
    }

    public void set(T elemento, int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximoNodo();
        }
        atual.setElemento(elemento);
    }

    public static void inserirOrdenado(ListaEncadeada<Integer> lista, int elemento) {
        Nodo<Integer> novoNodo = new Nodo<Integer>(elemento);
        if (lista.tamanho == 0) {
            lista.primeiro = novoNodo;
            lista.ultimo = novoNodo;
        } else if (elemento <= lista.primeiro.getElemento()) {
            novoNodo.setProximoNodo(lista.primeiro);
            lista.primeiro = novoNodo;
        } else if (elemento >= lista.ultimo.getElemento()) {
            lista.ultimo.setProximoNodo(novoNodo);
            lista.ultimo = novoNodo;

        } else {
            Nodo<Integer> atual = lista.primeiro;

            while (atual.getProximoNodo() != null && elemento > atual.getProximoNodo().getElemento()) {
                atual = atual.getProximoNodo();
            }
            novoNodo.setProximoNodo(atual.getProximoNodo());
            atual.setProximoNodo(novoNodo);
        }
        lista.tamanho++;
    }

    public int tamanho() {
        return this.tamanho;
    }

}

class Pilha<T> extends ListaEncadeada<T> implements IPilha<T> {

    @Override
    public void empilhar(T elemento) {
        this.adicionarNoFinal(elemento);
    }

    @Override
    public T desempilhar() throws EmptyStackException {
        if (this.estaVazia()) {
            throw new EmptyStackException();
        }
        T elementoDesempilhado = this.ultimo.getElemento();
        this.removerFinal();
        return elementoDesempilhado;
    }

    @Override
    public T topo() throws EmptyStackException {
        return this.ultimo.getElemento();
    }
    @Override
    public void limpa() {
        
        super.limpa();
    }

    @Override
    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public boolean estaOrdenadaCrescente(Pilha<Integer> pilha) {

        Nodo<Integer> atual = pilha.primeiro;
        for (int i = 0; i < pilha.tamanho() - 1; i++) {
            if (atual.getElemento() > atual.getProximoNodo().getElemento()) {
                return false;
            }

            atual = atual.getProximoNodo();
        }
        return true;
    }
    
    public boolean estaOrdenadaDecrescente(Pilha<Integer> pilha) {

        Nodo<Integer> atual = pilha.primeiro;
        for (int i = 0; i < pilha.tamanho() - 1; i++) {
            if (atual.getElemento() < atual.getProximoNodo().getElemento()) {
                return false;
            }

            atual = atual.getProximoNodo();
        }
        return true;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        //Pilha<Integer> pilha = new Pilha<Integer>();
        //pilha.empilhar(3);
        //pilha.empilhar(4);
        //System.out.println(pilha.estaOrdenadaDecrescente(pilha));
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");
        Pilha<Integer> pilha = new Pilha<Integer>();
        
        int N;
        
        do {
            N = scanner.nextInt();
            if(N==0) break;
            String linha="";
            while (true) {
                linha = scanner.next();
                if(linha.startsWith("0")) break;
                String[] linhaEmArray = linha.split(" ");
                for (int i = 0; i < linhaEmArray.length; i++) {
                    pilha.empilhar(Integer.parseInt(linhaEmArray[i]));
                }
                if(pilha.estaOrdenadaCrescente(pilha) || pilha.estaOrdenadaDecrescente(pilha)){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
                pilha.limpa();
            }
            System.out.println();
        } while (true);
        scanner.close();
    }
}
