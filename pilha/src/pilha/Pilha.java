package pilha;

import java.util.EmptyStackException;

public class Pilha<T> {
    private T[] elementos;
    private int tamanho;

    private static final int CAPACIDADE_PADRAO = 5;

    @SuppressWarnings("unchecked")
    public Pilha(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public Pilha(T[] elementosIniciais) {
        this.elementos = elementosIniciais;
        this.tamanho = elementosIniciais.length;
    }

    @SuppressWarnings("unchecked")
    public Pilha() {
        this.tamanho = 0;
        this.elementos = (T[]) new Object[CAPACIDADE_PADRAO];
    }

    public void empilha(T elemento) {
        if (_estaCheia())
            throw new StackOverflowError("A pilha atingiu sua capacidade maxima");
        // _aumentaCapacidade();
        this.elementos[tamanho] = elemento;
        this.tamanho++;
    }

    /*
     * private void _aumentaCapacidade() {
     * if (_estaCheia()) {
     * int capacidadeAtual = this.elementos.length;
     * int novaCapacidade = capacidadeAtual * 2;
     * 
     * @SuppressWarnings("unchecked")
     * T[] novoArrayMaior = (T[]) new Object[novaCapacidade];
     * for (int i = 0; i < this.elementos.length; i++) {
     * novoArrayMaior[i] = this.elementos[i];
     * }
     * this.elementos = novoArrayMaior;
     * }
     * }
     */
    public boolean estaVazia() {
        return this.tamanho == 0;

    }

    private boolean _estaCheia() {
        return this.tamanho == this.elementos.length;
    }

    public T topo() {
        if (estaVazia())
            return null;
        return this.elementos[this.tamanho - 1];

    }

    public T desempilha() {
        if (estaVazia()) {
            throw new EmptyStackException();
        }
        T elementoDesempilhado = this.elementos[this.tamanho - 1];
        this.tamanho--;
        return elementoDesempilhado;
    }

    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        String s = "[";

        for (int i = 0; i < tamanho; i++) {
            if (i == this.tamanho - 1) {
                s = s + this.elementos[i];
            } else {
                s = s + this.elementos[i] + ", ";
            }
        }
        s = s + "]";
        return s;

    }
}
