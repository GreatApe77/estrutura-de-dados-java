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
        this.tamanho++;
    }
    public void adicionarFinal(T elemento){
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if(this.tamanho==0){
            this.primeiro = novoNodo;
            this.ultimo = novoNodo;
        }else{
            this.ultimo.setProximo(novoNodo);
            novoNodo.setAnterior(this.ultimo);
            this.ultimo = novoNodo;
        }
        this.tamanho++;
    }
    public void adicionar(int posicao, T elemento){
        if(posicao<0 || posicao>=this.tamanho){
            throw new IndexOutOfBoundsException("Posicao invalida");
        }
        
        if(posicao==0){
            this.adicionarComeco(elemento);
            return;
        }
        if(posicao == this.tamanho-1){
            this.adicionarFinal(elemento);
            return;
        }
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao-1; i++) {
            atual = atual.getProximo();
        }
        novoNodo.setAnterior(atual);
        novoNodo.setProximo(atual.getProximo());
        atual.getProximo().setAnterior(novoNodo);
        atual.setProximo(novoNodo);

        this.tamanho++;
        
    }


    @Override
    public String toString() {
        
        StringBuilder s = new StringBuilder();
        s.append("[");
        Nodo<T> atual = this.primeiro;
        while (atual!=null) {
            if(atual==ultimo){
                s.append(atual.getElemento());
            }else{
                s.append(atual.getElemento());
                s.append(", ");
            }
            atual = atual.getProximo();
        }
        s.append("]");
        return s.toString();
    }
}
