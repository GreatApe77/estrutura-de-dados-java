package com.mateusnavarro77.estruturas.fila;

import java.util.NoSuchElementException;

public class Fila<T> extends ListaDuplamenteEncadeada<T> implements IFila<T> {

    @Override
    public void enfileirar(T elemento) {
        this.adicionarFinal(elemento);
    }

    @Override
    public T desenfileirar() throws NoSuchElementException {
        if(estaVazia()) throw new NoSuchElementException();
        T elemento = this.primeiro.getElemento();
        this.removerComeco();
        return elemento;

    }

    @Override
    public T primeiroDaFila() throws NoSuchElementException {
        if(estaVazia()) throw new NoSuchElementException();
        return  this.primeiro.getElemento();
    }

    @Override
    public boolean estaVazia() {
        return this.tamanho==0;
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }
    
}