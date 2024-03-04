package com.mateus.lista.encadeada;

public class Nodo<T> {
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
