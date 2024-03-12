import java.io.IOException;
import java.util.Scanner;

class Nodo<T> {
    private Nodo<T> anterior;
    private Nodo<T> proximo;
    private T elemento;

    public Nodo(T elemento) {
        this.anterior = null;
        this.proximo = null;
        this.elemento = elemento;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public Nodo<T> getProximo() {
        return proximo;
    }
}

class ListaDuplamenteEncadeada<T> {
    private int tamanho;
    private Nodo<T> primeiro;
    private Nodo<T> ultimo;

    public ListaDuplamenteEncadeada() {
        this.tamanho = 0;
        this.primeiro = null;
        this.ultimo = null;
    }

    public void adicionarComeco(T elemento) {
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if (this.tamanho == 0) {
            this.primeiro = novoNodo;
            this.ultimo = novoNodo;
        } else {
            primeiro.setAnterior(novoNodo);
            novoNodo.setProximo(primeiro);
            primeiro = novoNodo;
        }
        this.tamanho++;
    }

    public void adicionarFinal(T elemento) {
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if (this.tamanho == 0) {
            this.primeiro = novoNodo;
            this.ultimo = novoNodo;
        } else {
            this.ultimo.setProximo(novoNodo);
            novoNodo.setAnterior(this.ultimo);
            this.ultimo = novoNodo;
        }
        this.tamanho++;
    }

    public void adicionar(int posicao, T elemento) {
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IndexOutOfBoundsException("Posicao invalida");
        }

        if (posicao == 0) {
            this.adicionarComeco(elemento);
            return;
        }
        if (posicao == this.tamanho - 1) {
            this.adicionarFinal(elemento);
            return;
        }
        Nodo<T> novoNodo = new Nodo<T>(elemento);

        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.getProximo();
        }
        novoNodo.setAnterior(atual);
        novoNodo.setProximo(atual.getProximo());
        atual.getProximo().setAnterior(novoNodo);
        atual.setProximo(novoNodo);

        this.tamanho++;

    }

    public void removerComeco() {
        if (this.tamanho == 0) {
            throw new IndexOutOfBoundsException("Lista esta vazia");

        }
        if (this.tamanho == 1) {
            this.primeiro = null;
            this.ultimo = null;
        } else {

            this.primeiro = primeiro.getProximo();
            this.primeiro.setAnterior(null);
        }
        this.tamanho--;
    }

    public T removerFinal() {
        if (this.tamanho == 0) {
            throw new IndexOutOfBoundsException("Lista esta vazia");

        }
        T elementoRemovido;
        if (this.tamanho == 1) {
            elementoRemovido = this.primeiro.getElemento();
            this.primeiro = null;
            this.ultimo = null;

        } else {
            elementoRemovido = this.ultimo.getElemento();
            this.ultimo = this.ultimo.getAnterior();
            this.ultimo.setProximo(null);
        }
        this.tamanho--;
        return elementoRemovido;
    }

    public void remover(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Posicao invalida");
        }
        if (posicao == 0) {
            this.removerComeco();
            return;
        }
        if (posicao == this.tamanho - 1) {
            this.removerFinal();
            return;
        }

        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao - 1; i++) {

            atual = atual.getProximo();
        }
        atual.getProximo().getProximo().setAnterior(atual);
        atual.setProximo(atual.getProximo().getProximo());
        this.tamanho--;
    }

    public void set(int posicao, T elemento) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Posicao invalida");
        }
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        atual.setElemento(elemento);
    }

    public T get(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Posicao invalida");
        }
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual.getElemento();
    }
    public T lerTopo(){
        return this.ultimo.getElemento();
    }

    public void limpa() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }
    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("[");
        Nodo<T> atual = this.primeiro;
        while (atual != null) {
            if (atual == ultimo) {
                s.append(atual.getElemento());
            } else {
                s.append(atual.getElemento());
                s.append(", ");
            }
            atual = atual.getProximo();
        }
        s.append("]");
        return s.toString();
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        ListaDuplamenteEncadeada<Integer> baralho = new ListaDuplamenteEncadeada<Integer>();

        Scanner scanner = new Scanner(System.in);
        int N;
        do {
            N = scanner.nextInt();
            if(N==0) break;
            for (int i = N; i >= 1; i--) {
                baralho.adicionarFinal(i);
            }
            String discartedCardasLinha = "Discarded cards: ";
            while (baralho.tamanho()>=2) {
                int removido = baralho.removerFinal();
                int topoAposRemocao = baralho.removerFinal();
                baralho.adicionarComeco(topoAposRemocao);
                if(baralho.tamanho()==1){
                    discartedCardasLinha = discartedCardasLinha + removido;
                }else{
                    discartedCardasLinha = discartedCardasLinha + removido + ", ";
                }
            }
            System.out.println(discartedCardasLinha);
            System.out.println("Remaining card: "+baralho.lerTopo());
            baralho.limpa();
        } while (true);
        scanner.close();
        // baralho.adicionarFinal(2);
        // baralho.adicionarFinal(7);

        // System.out.println(baralho);
    }
}
