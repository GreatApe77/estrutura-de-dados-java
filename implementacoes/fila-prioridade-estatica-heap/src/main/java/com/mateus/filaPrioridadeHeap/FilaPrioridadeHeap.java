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
    protected Valor[] heap;

    @SuppressWarnings("unchecked")
    public FilaPrioridadeHeap(int capacidade){
        this.comparador = new ComparadorPadrao<>();
        this.heap = (Valor[]) new Object[capacidade];
        this.tamanho = 0;
        
    }
    @Override
    public void insere(Chave chave, Valor valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insere'");
    }

    @Override
    public Elemento<Chave, Valor> frente() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'frente'");
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

}
