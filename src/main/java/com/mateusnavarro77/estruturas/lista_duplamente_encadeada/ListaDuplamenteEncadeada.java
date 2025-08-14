package com.mateusnavarro77.estruturas.lista_duplamente_encadeada;

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
        if(posicao<0 || posicao>this.tamanho){
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

    public void removerComeco(){
        if(this.tamanho==0){
            throw new IndexOutOfBoundsException("Lista esta vazia");

        }
        if(this.tamanho==1){
            this.primeiro =null;
            this.ultimo =null;
        }else {
            
            this.primeiro = primeiro.getProximo();
            this.primeiro.setAnterior(null);
        }
        this.tamanho--;
    }

    public void removerFinal(){
        if(this.tamanho==0){
            throw new IndexOutOfBoundsException("Lista esta vazia");

        }
        if(this.tamanho==1){
            this.primeiro =null;
            this.ultimo =null;
        }else{
            this.ultimo = this.ultimo.getAnterior();
            this.ultimo.setProximo(null);
        }
        this.tamanho--;
    }
    public void remover(int posicao){
        if(posicao<0 || posicao>=this.tamanho){
            throw new IndexOutOfBoundsException("Posicao invalida");
        }
        if(posicao==0){
            this.removerComeco();
            return;
        }
        if(posicao==this.tamanho-1){
            this.removerFinal();
            return;
        }

        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao-1; i++) {
            
            atual = atual.getProximo();
        }
        atual.getProximo().getProximo().setAnterior(atual);
        atual.setProximo(atual.getProximo().getProximo());
        this.tamanho--;
    }

    public void set(int posicao,T elemento){
        if(posicao<0 || posicao>=this.tamanho){
            throw new IndexOutOfBoundsException("Posicao invalida");
        }
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        atual.setElemento(elemento);
    }
    public T get(int posicao){
        if(posicao<0 || posicao>=this.tamanho){
            throw new IndexOutOfBoundsException("Posicao invalida");
        }
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual.getElemento();
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