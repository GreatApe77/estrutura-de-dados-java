package com.mateus.lista.duplamente.encadeada;

public class ListaDuplamenteEncadeada<T> {
    private int tamanho;
    private Nodo<T> primeiro;
    private Nodo<T> ultimo;

    public ListaDuplamenteEncadeada(){
        this.tamanho= 0;
        this.primeiro = null;
        this.ultimo = null;
    }

    public void adicionarComeco(T elemento){
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if(this.tamanho==0){
            this.primeiro = novoNodo;
            this.ultimo = novoNodo;
        }else{
            primeiro.setAnterior(novoNodo);
            novoNodo.setProximo(primeiro);
            primeiro = novoNodo;
        }
    }
    public void adicionarFinal(T elemento){

    }
    public void adicionar(int posicao, T elemento){

    }


    @Override
    public String toString() {
        
        StringBuilder s = new StringBuilder();
        s.append("[");
        Nodo<T> atual = this.primeiro;
    }
}
