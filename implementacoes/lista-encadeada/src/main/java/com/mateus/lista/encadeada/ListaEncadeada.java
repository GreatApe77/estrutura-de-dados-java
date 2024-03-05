package com.mateus.lista.encadeada;

public class ListaEncadeada<T> {
    private Nodo<T> primeiro;
    private Nodo<T> ultimo;
    private int tamanho;
    public ListaEncadeada(){
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void adicionarNoFinal(T elemento){
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if(this.tamanho==0){
            this.primeiro = novoNodo;
            this.ultimo = novoNodo;
        }
        else{
            
                this.ultimo.setProximoNodo(novoNodo);
                this.ultimo = novoNodo;
            
        }
        this.tamanho++;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("[");

        Nodo<T> atual = this.primeiro;

        while(atual!=null){
            s.append(atual.getElemento());
            if(atual.getProximoNodo()!=null){

                s.append(", ");
            }
            atual = atual.getProximoNodo();            
        }
        s.append("]");

        return s.toString();
    }

}
