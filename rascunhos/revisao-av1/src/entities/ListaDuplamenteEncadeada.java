package entities;

import entities.doublynode.Nodo;

public class ListaDuplamenteEncadeada<T> implements ILista<T> {
    protected Nodo<T> primeiro;
    protected Nodo<T> ultimo;
    protected int tamanho;

    public ListaDuplamenteEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void insereOrdenado(T elemento) {
        Comparable elementoComparavel = (Comparable) elemento;
        if(estaVazia()){
            inserirFinal(elemento);
            return;
        }
        else{
            if(tamanho()==1){
                if(elementoComparavel.compareTo(primeiro.getElemento())==1||elementoComparavel.compareTo(primeiro.getElemento())==0){
                    inserirFinal(elemento);
                }else{
                    inserirComeco(elemento);
                }
                return;
            }
            Nodo<T> novoNodo = new Nodo<T>(elemento);
            Nodo<T> atual = this.primeiro;
            while (atual.getProximo()!=null && (elementoComparavel.compareTo(atual.getProximo().getElemento())==1)) {
                atual = atual.getProximo();
            }
            novoNodo.setProximo(atual.getProximo());
            novoNodo.setAnterior(atual);
            atual.getProximo().setAnterior(novoNodo);
            atual.setProximo(novoNodo);

            _incrementarTamanho();

        }

        
    }

    @Override
    public void inserirComeco(T elemento) {
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if (estaVazia()) {
            this.primeiro = novoNodo;
            this.ultimo = novoNodo;
            _incrementarTamanho();
            return;
        }

        novoNodo.setProximo(primeiro);
        primeiro.setAnterior(novoNodo);
        primeiro = novoNodo;
        _incrementarTamanho();

    }

    @Override
    public void inserirFinal(T elemento) {
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if (estaVazia()) {
            this.primeiro = novoNodo;
            this.ultimo = novoNodo;
            _incrementarTamanho();
            return;
        }
        novoNodo.setAnterior(ultimo);
        ultimo.setProximo(novoNodo);
        ultimo = novoNodo;
        _incrementarTamanho();

    }

    @Override
    public void removerPosicao(int posicao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerPosicao'");
    }

    @Override
    public T get(int posicao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public void removerComeco() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerComeco'");
    }

    @Override
    public void removerFinal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerFinal'");
    }

    @Override
    public void limpa() {
        this.tamanho = 0;
        this.primeiro = null;
        this.ultimo = null;
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        String s = "[";
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < tamanho(); i++) {
            if (i == tamanho() - 1) {
                s = s + atual.getElemento();
            } else {
                s = s + atual.getElemento() + ", ";
            }
            atual = atual.getProximo();
        }
        s = s + "]";
        return s;
    }

    public void imprimeEmOrdem() {
        System.out.println(this);
    }

    public void imprimeInvertido() {
        String s = "[";
        Nodo<T> atual = this.ultimo;
        for (int i = 0; i < tamanho(); i++) {
            if (i == tamanho() - 1) {
                s = s + atual.getElemento();
            } else {
                s = s + atual.getElemento() + ", ";
            }
            atual = atual.getAnterior();
        }
        s = s + "]";
        System.out.println(s);
    }

    @Override
    public boolean estaVazia() {
        return this.tamanho() == 0;
    }

    private void _incrementarTamanho() {
        this.tamanho++;
    }

    private void _decrementarTamanho() {
        this.tamanho--;
    }

}