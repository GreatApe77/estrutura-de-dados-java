package com.mateus.pilha;

import java.util.EmptyStackException;

public class Pilha<T> extends ListaEncadeada<T> implements IPilha<T> {

    @Override
    public void empilhar(T elemento) {
        this.adicionarNoFinal(elemento);
    }

    @Override
    public T desempilhar() throws EmptyStackException {
        if(this.estaVazia()){
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
    public boolean estaVazia() {
        return this.tamanho==0;
    }
    
}
