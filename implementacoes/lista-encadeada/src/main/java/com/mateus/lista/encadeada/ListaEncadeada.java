package com.mateus.lista.encadeada;

public class ListaEncadeada<T> {
    private Nodo<T> primeiro;
    private Nodo<T> ultimo;
    private int tamanho;

    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void removerFinal(){
        if(this.tamanho==0){
            throw new IllegalArgumentException("A lista esta vazia");
        }
        if(tamanho==1){
            this.primeiro = null;
            this.ultimo = null;
            return;
        }
        Nodo<T> penultimo = this._getNodo(tamanho-2);
        this.ultimo = penultimo;
        penultimo.setProximoNodo(null);
        this.tamanho--;
    }
    public void adicionarEmPosicao(T elemento, int posicao) {
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        if (posicao == 0) {
            this.adicionarNoComeco(elemento);
            return;
        }
        if (posicao == this.tamanho) {
            this.adicionarNoFinal(elemento);
            return;
        }

        Nodo<T> novoNodo = new Nodo<T>(elemento);

        Nodo<T> antesDoNovo = this._getNodo(posicao - 1); // pegar o que vai ficar antes dele
        novoNodo.setProximoNodo(antesDoNovo.getProximoNodo());
        antesDoNovo.setProximoNodo(novoNodo);
        this.tamanho++;
    }

    public void adicionarNoFinal(T elemento) {
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if (this.tamanho == 0) {
            this.primeiro = novoNodo;
            this.ultimo = novoNodo;
        } else {

            this.ultimo.setProximoNodo(novoNodo);
            this.ultimo = novoNodo;

        }
        this.tamanho++;
    }

    public void adicionarNoComeco(T elemento) {
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        //
        // [] -> [] -> [] -> []
        //
        // prim ultimo
        //
        if (tamanho == 0) {
            this.primeiro = novoNodo;
            this.ultimo = novoNodo;
        } else {
            novoNodo.setProximoNodo(this.primeiro);
            this.primeiro = novoNodo;
        }

        tamanho++;
    }

    public T get(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximoNodo();
        }
        return atual.getElemento();
    }

    private Nodo<T> _getNodo(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximoNodo();
        }
        return atual;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("[");

        Nodo<T> atual = this.primeiro;

        while (atual != null) {
            s.append(atual.getElemento());
            if (atual.getProximoNodo() != null) {

                s.append(", ");
            }
            atual = atual.getProximoNodo();
        }
        s.append("]");

        return s.toString();
    }

    public int tamanho() {
        return this.tamanho;
    }

}
