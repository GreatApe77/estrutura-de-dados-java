package com.mateusnavarro77.estruturas.pilha;
import java.util.EmptyStackException;
public interface IPilha<T> {
    void empilhar(T elemento);
    T desempilhar() throws EmptyStackException;
    T topo() throws EmptyStackException;
    boolean estaVazia();
    int tamanho();
}