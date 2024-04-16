package com.mateus.filaDinamica;

class Nodo<T> {
    private T elemento;
    private Nodo<T> proximoNodo;

    public Nodo(T elemento){
        this.elemento = elemento;
    }

    public T getElemento() {
        return elemento;
    }
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    public void setProximoNodo(Nodo<T> proximoNodo) {
        this.proximoNodo = proximoNodo;
    }
    public Nodo<T> getProximoNodo() {
        return this.proximoNodo;
    }
}