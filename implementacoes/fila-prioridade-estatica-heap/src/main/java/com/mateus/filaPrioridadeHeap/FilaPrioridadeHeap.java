package com.mateus.filaPrioridadeHeap;

import java.util.Comparator;

public class FilaPrioridadeHeap<Chave, Valor> implements FilaPrioridade<Chave, Valor> {

    class ElementoDaFila implements Elemento<Chave, Valor> {
        Chave chave;
        Valor valor;

        @Override
        public Chave getChave() {
            return this.chave;
        }

        @Override
        public Valor getValor() {
            return this.valor;
        }

        @Override
        public String toString() {
            return "(" + chave + " - " + valor + ")";
        }

    }

    private Comparator<Chave> comparador;
    protected int tamanho;
    protected Elemento<Chave,Valor>[] heap;

    @SuppressWarnings("unchecked")
    public FilaPrioridadeHeap(int capacidade){
        this.comparador = new ComparadorPadrao<>();
        this.heap = (Elemento<Chave,Valor>[]) new Object[capacidade];
        this.tamanho = 0;
        
    }
    @Override
    public void insere(Chave chave, Valor valor) {
        
    }

    @Override
    public Elemento<Chave, Valor> frente() {
        if(estaVazia()) throw new Error("Fila Vazia");
        return heap[0];
    }

    @Override
    public Elemento<Chave, Valor> remove() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public boolean estaVazia() {
        return tamanho() ==0;
    }

    public boolean estaCheia() {
        return this.heap.length==tamanho();
    }
    //
    private int  filhoEsquerdo(int i){
        return 2*i;
    }
    private int filhoDireito(int i){
        return 2*i+1;
    }
    private int pai(int i){
        return i/2;
    }
}
