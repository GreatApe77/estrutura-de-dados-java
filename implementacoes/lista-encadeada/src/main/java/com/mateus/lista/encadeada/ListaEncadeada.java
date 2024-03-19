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

    public void limpa() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void removerEmPosicao(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        if (posicao == 0) {
            this.removerComeco();
            return;
        }
        if (posicao == this.tamanho - 1) {
            this.removerFinal();
            return;
        }
        Nodo<T> anteriorAoRemovido = this._getNodo(posicao - 1);
        Nodo<T> removido = anteriorAoRemovido.getProximoNodo();
        anteriorAoRemovido.setProximoNodo(removido.getProximoNodo());
        this.tamanho--;
    }

    public void removerComeco() {
        if (this.tamanho == 0) {
            throw new IllegalArgumentException("A lista esta vazia");
        }
        this.primeiro = this.primeiro.getProximoNodo();
        this.tamanho--;
    }

    public void removerFinal() {
        if (this.tamanho == 0) {
            throw new IllegalArgumentException("A lista esta vazia");
        }
        if (tamanho == 1) {
            this.primeiro = null;
            this.ultimo = null;
            this.tamanho--;
            return;
        }
        Nodo<T> penultimo = this._getNodo(tamanho - 2);
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

    public int indiceDe(T elemento) {

        if (this.tamanho == 0) {
            return -1;
        }
        int indice = 0;
        Nodo<T> atual = this.primeiro;
        while (atual != null) {
            if (atual.getElemento() == elemento) {
                return indice;
            }
            atual = atual.getProximoNodo();
            indice++;
        }
        return -1;

    }

    public static void ordena(ListaEncadeada<Integer> lista) {
        for (int i = 0; i < lista.tamanho(); i++) {
            for (int j = 0; j < lista.tamanho() - 1; j++) {
                if (lista.get(j) > lista.get(j + 1)) {
                    int auxiliar = lista.get(j + 1);
                    lista.set(lista.get(j), j + 1);
                    lista.set(auxiliar, j);
                }
            }
        }
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

    public void set(T elemento, int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximoNodo();
        }
        atual.setElemento(elemento);
    }

    @SuppressWarnings("unchecked")
    public void insereOrdenado(T elemento){
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if(primeiro==null || ((Comparable<T>) elemento).compareTo(primeiro.getElemento())==-1 ||((Comparable<T>) elemento).compareTo(primeiro.getElemento())==0  ){
            novoNodo.setProximoNodo(this.primeiro);
            this.primeiro = novoNodo;
            if(this.ultimo==null){
                this.ultimo = novoNodo;
            }
        }else{
            Nodo<T> atual = this.primeiro;
            while (atual.getProximoNodo()!=null && ((Comparable<T>)atual.getProximoNodo().getElemento()).compareTo(elemento)==-1) {
                atual = atual.getProximoNodo();
            }
            novoNodo.setProximoNodo(atual.getProximoNodo());
            atual.setProximoNodo(novoNodo);
            if(atual==this.ultimo){
                ultimo = novoNodo;
            }
        }
        this.tamanho++;
    }

    public static void inserirOrdenado(ListaEncadeada<Integer> lista, int elemento) {
        Nodo<Integer> novoNodo = new Nodo<Integer>(elemento);
        if (lista.tamanho == 0) {
            lista.primeiro = novoNodo;
            lista.ultimo = novoNodo;
        } else if (elemento <= lista.primeiro.getElemento()) {
            novoNodo.setProximoNodo(lista.primeiro);
            lista.primeiro = novoNodo;
        } else if (elemento >= lista.ultimo.getElemento()) {
            lista.ultimo.setProximoNodo(novoNodo);
            lista.ultimo = novoNodo;

        } else {
            Nodo<Integer> atual = lista.primeiro;

            while (atual.getProximoNodo() != null && elemento > atual.getProximoNodo().getElemento()) {
                atual = atual.getProximoNodo();
            }
            novoNodo.setProximoNodo(atual.getProximoNodo());
            atual.setProximoNodo(novoNodo);
        }
        lista.tamanho++;
    }

    public int tamanho() {
        return this.tamanho;
    }

}
