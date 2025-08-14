
import java.util.Scanner;
import java.io.IOException;

class Lista<T> {
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

    public Lista(Lista<T> lista) {
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

    public Lista<T> copia() {
        return new Lista<T>(this);
    }
}

class QuickSort {
    private static int partition(Lista<Integer> lista, int comeco, int fim) {
        int pivot = lista.pesquisarPorIndice(fim);
        int i = comeco - 1;
        for (int j = comeco; j <= fim - 1; j++) {
            if (lista.pesquisarPorIndice(j) < pivot) {
                i++;
                int auxiliar = lista.pesquisarPorIndice(i);
                lista.setElemento(i, lista.pesquisarPorIndice(j));
                lista.setElemento(j, auxiliar);
            }
        }
        i++;
        int auxiliar = lista.pesquisarPorIndice(i);
        lista.setElemento(i, lista.pesquisarPorIndice(fim));
        lista.setElemento(fim, auxiliar);
        return i;
    }

    public static void quickSort(Lista<Integer> lista, int comeco, int fim) {
        if (fim <= comeco) {
            return;

        }
        int pivot = partition(lista, comeco, fim);
        quickSort(lista, pivot + 1, fim);
        quickSort(lista, comeco, pivot - 1);

    }

    private static int partitionDecrescente(Lista<Integer> lista, int comeco, int fim) {
        int pivot = lista.pesquisarPorIndice(fim);
        int i = comeco - 1;
        for (int j = comeco; j <= fim - 1; j++) {
            if (lista.pesquisarPorIndice(j) > pivot) {
                i++;
                int auxiliar = lista.pesquisarPorIndice(i);
                lista.setElemento(i, lista.pesquisarPorIndice(j));
                lista.setElemento(j, auxiliar);
            }
        }
        i++;
        int auxiliar = lista.pesquisarPorIndice(i);
        lista.setElemento(i, lista.pesquisarPorIndice(fim));
        lista.setElemento(fim, auxiliar);
        return i;
    }

    public static void ordenaListaDecrescente(Lista<Integer> lista, int comeco, int fim) {
        if (fim <= comeco) {
            return;

        }
        int pivot = partitionDecrescente(lista, comeco, fim);
        ordenaListaDecrescente(lista, pivot + 1, fim);
        ordenaListaDecrescente(lista, comeco, pivot - 1);
    }
}

public class Main {
    /*
     * public static void ordenaListaCrescente(Lista<Integer> lista){
     * for (int i = 0; i < lista.tamanho(); i++) {
     * for (int j = 0; j < lista.tamanho()-1; j++) {
     * if(lista.pesquisarPorIndice(j)>lista.pesquisarPorIndice(j+1)){
     * int auxiliar = lista.pesquisarPorIndice(j+1);
     * lista.setElemento(j+1, lista.pesquisarPorIndice(j));
     * lista.setElemento(j,auxiliar);
     * }
     * }
     * }
     * }
     * public static void ordenaListaDecrescente(Lista<Integer> lista){
     * for (int i = 0; i < lista.tamanho(); i++) {
     * for (int j = 0; j < lista.tamanho()-1; j++) {
     * if(lista.pesquisarPorIndice(j)<lista.pesquisarPorIndice(j+1)){
     * int auxiliar = lista.pesquisarPorIndice(j+1);
     * lista.setElemento(j+1, lista.pesquisarPorIndice(j));
     * lista.setElemento(j,auxiliar);
     * }
     * }
     * }
     * }
     */
    public static void main(String[] args) throws IOException {

        //Integer[] l = new Integer[] { 123, 42, 2, 1, 4, 6, 734, 3, 3, 3, 5, 7, 444, 3, 222, 4, 6, 7, 6, 45, 3, 2, 1, 1,
        //        5 };
//
        //Lista<Integer> lista = new Lista<Integer>(l);
        //QuickSort.quickSort(lista, 0, lista.tamanho() - 1);
        //System.out.println(lista);
        //QuickSort.ordenaListaDecrescente(lista, 0, lista.tamanho() - 1);
        //System.out.println(lista);
        Lista<Integer> pares = new Lista<Integer>(10000);
        Lista<Integer> impares = new Lista<Integer>(10000);

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int entradaN = scanner.nextInt();
            if(entradaN%2==0){
                pares.adicionarElementoNoFinal(entradaN);
            }else{
                impares.adicionarElementoNoFinal(entradaN);
            }
        }
        scanner.close();
        QuickSort.quickSort(pares, 0, pares.tamanho()-1);
        QuickSort.ordenaListaDecrescente(impares, 0, impares.tamanho()-1);
        for (int i = 0; i < pares.tamanho(); i++) {
            System.out.println(pares.pesquisarPorIndice(i));
        }
        for (int i = 0; i < impares.tamanho(); i++) {
            System.out.println(impares.pesquisarPorIndice(i));
        }
        
        //System.out.println(impares);

        
    }
}