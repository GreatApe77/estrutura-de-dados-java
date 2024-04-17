import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            
        }
    }
}
class ListaEncadeada<T> {
    private Nodo<T> primeiro;
    private Nodo<T> ultimo;
    private int tamanho;

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

    @SuppressWarnings("unchecked")
    public void insereOrdenado(T elemento){
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if(primeiro==null || ((Comparable<T>) elemento).compareTo(primeiro.getElemento())==-1 ||((Comparable<T>) elemento).compareTo(primeiro.getElemento())==0  ){
            novoNodo.setProximoNodo(this.primeiro);
            this.primeiro = novoNodo;
            if(this.ultimo==null){
                this.ultimo = novoNodo;
            }
        }else{
            Nodo<T> atual = this.primeiro;
            while (atual.getProximoNodo()!=null && ((Comparable<T>)atual.getProximoNodo().getElemento()).compareTo(elemento)==-1) {
                atual = atual.getProximoNodo();
            }
            novoNodo.setProximoNodo(atual.getProximoNodo());
            atual.setProximoNodo(novoNodo);
            if(atual==this.ultimo){
                ultimo = novoNodo;
            }
        }
        this.tamanho++;
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
class Nodo<T> {
    private Nodo<T> proximoNodo;
    private T elemento;

    public Nodo(T elemento){
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


class Lista<T>  {
    private T[] elementos;
    private int tamanho;
    private int tamanhoPadrao = 5;

    @SuppressWarnings("unchecked")
    public Lista(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public Lista(T[] elementosIniciais) {
        this.elementos = elementosIniciais;
        this.tamanho = elementosIniciais.length;
    }
    public Lista(Lista<T> lista){
        this.tamanho = lista.tamanho();
        this.elementos = lista.toArray();
    }
    @SuppressWarnings("unchecked")
    public Lista() {
        this.elementos = (T[]) new Object[this.tamanhoPadrao];
        this.tamanho = 0;
    }

    
    public int tamanho() {
        return this.tamanho;
    }

    
    public void adicionarElemento(T elemento, int posicao) {
        _lancarErroDePosicaoInvalida(posicao);
        _aumentarCapacidade();
        // inserir x na posicao 4
        // [a b c d e e f] t = 6 i=4
        for (int i = tamanho - 1; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        // [a b c d x e f]
        setElemento(posicao, elemento);
        this.tamanho++;
    }

    
    public void setElemento(int posicao, T elemento) {
        this.elementos[posicao] = elemento;
    }

    @SuppressWarnings("unchecked")
    
    public void limpar() {
        this.elementos = (T[]) new Object[tamanhoPadrao];
        this.tamanho = 0;
    }

    
    public boolean estaVazia() {
        return _estaVazia();
    }

    // privados
    private boolean _posicaoValida(int posicao) {
        return posicao >= 0 && posicao < tamanho;
    }

    private void _lancarErroDePosicaoInvalida(int posicao) throws IllegalArgumentException {
        if (!_posicaoValida(posicao))
            throw new IllegalArgumentException("Tentando acessar posicao invalida");
    }

    private void _aumentarCapacidade() {
        if (_estaCheia()) {
            int capacidadeAtual = this.elementos.length;
            int novaCapacidade = capacidadeAtual * 2;
            @SuppressWarnings("unchecked")
            T[] novoArrayMaior = (T[]) new Object[novaCapacidade];
            for (int i = 0; i < this.tamanho; i++) {
                novoArrayMaior[i] = this.elementos[i];
            }
            this.elementos = novoArrayMaior;
        }
    }

    private boolean _estaCheia() {
        return this.tamanho == this.elementos.length;
    }

    private boolean _estaVazia() {
        return this.tamanho == 0;
    }

    
    public void adicionarElementoNoFinal(T elemento) {
        _aumentarCapacidade();
        setElemento(this.tamanho, elemento);
        this.tamanho++;
    }

    
    public T pesquisarPorIndice(int posicao) throws IllegalArgumentException {
        _lancarErroDePosicaoInvalida(posicao);
        return this.elementos[posicao];
    }

    
    // Big O(n)
    public int pesquisarIndiceDe(T elemento) {

        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }

        }
        return -1;
    }

    public int pesquisarUltimoIndiceDe(T elemento) {

        for (int i = this.tamanho - 1; i >= 0; i--) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }

        }
        return -1;
    }

    
    public boolean contem(T elemento) {
        return pesquisarIndiceDe(elemento) != -1;
    }

    
    public String toString() {
        StringBuilder vetorEmString = new StringBuilder();
        vetorEmString.append("[");

        for (int i = 0; i < this.tamanho; i++) {
            vetorEmString.append(this.elementos[i]);
            if (i < this.tamanho - 1) {
                vetorEmString.append(", ");
            }
        }
        vetorEmString.append("]");

        return vetorEmString.toString();
    }

    
    public boolean removerPorPosicao(int posicao) {
        _lancarErroDePosicaoInvalida(posicao);
        // [a b c e f ]|f] i=4
        for (int i = posicao; i < tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        this.tamanho--;
        return true;
    }

    
    public boolean removerElemento(T elemento) {
        int posicao = pesquisarIndiceDe(elemento);
        if (posicao == -1)
            return false;
        return this.removerPorPosicao(posicao);
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] formatoArray = (T[]) new Object[this.tamanho];
        for (int i = 0; i < formatoArray.length; i++) {
            formatoArray[i] = this.elementos[i];
        }
        return formatoArray;
    }

    
    public Lista<T> copia(){
        return new Lista<T>(this);
    }
}