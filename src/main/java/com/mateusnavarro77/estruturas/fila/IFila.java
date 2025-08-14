package com.mateusnavarro77.estruturas.fila;

import java.util.NoSuchElementException;

public interface IFila<T> {
     void enfileirar(T elemento);
    T desenfileirar() throws NoSuchElementException;
    T primeiroDaFila() throws NoSuchElementException;
    boolean estaVazia();
    int tamanho();
}