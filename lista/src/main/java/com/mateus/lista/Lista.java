package com.mateus.lista;

public class Lista<T> implements ILista<T> {
    private T[] elementos;
    private int tamanho;
    private int tamanhoPadrao = 5;

    @SuppressWarnings("unchecked")
    public Lista(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho=0;
    }

    public Lista(T[] elementosIniciais) {
        this.elementos = elementosIniciais;
        this.tamanho = elementosIniciais.length;
    }

    @SuppressWarnings("unchecked")
    public Lista() {
        this.elementos = (T[]) new Object[this.tamanhoPadrao];
        this.tamanho=0;
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public void adicionarElemento(T elemento, int posicao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarElemento'");
    }

    @Override
    public void setElemento(int posicao, T elemento) {
        this.elementos[posicao] = elemento;
    }

    @Override
    public void limpar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'limpar'");
    }

    // privados
    private boolean _posicaoValida(int posicao) {
        return posicao >= 0 && posicao < tamanho;
    }

    private void _lancarErroDePosicaoInvalida(int posicao) throws IllegalArgumentException {
        if (!_posicaoValida(posicao))
            throw new IllegalArgumentException("Tentando acessar posicao invalida");
    }
    private void _aumentarCapacidade(){
        if(_estaCheia()){
            int capacidadeAtual = this.elementos.length;
            int novaCapacidade = capacidadeAtual*2;
            T[] novoArrayMaior = (T[]) new Object[novaCapacidade];
            for (int i = 0; i < this.tamanho; i++) {
                novoArrayMaior[i] = this.elementos[i];
            }
            this.elementos = novoArrayMaior;
        }
    }
    private boolean _estaCheia(){
        return this.tamanho == this.elementos.length;
    }
    private boolean _estaVazia(){
        return this.tamanho ==0;
    }

    @Override
    public void adicionarElementoNoFinal(T elemento) {
        _aumentarCapacidade();
        setElemento(this.tamanho, elemento);
        this.tamanho++;
    }

    @Override
    public T pesquisarPorIndice(int posicao) throws IllegalArgumentException {
        //_lancarErroDePosicaoInvalida(posicao);
        return this.elementos[posicao];
    }

    @Override
    public String toString() {
        StringBuilder vetorEmString = new StringBuilder();
        vetorEmString.append("[");

        for (int i = 0; i < this.tamanho; i++) {
            vetorEmString.append(this.elementos[i]);
            if (i < this.tamanho - 1) {
                vetorEmString.append(", ");
            }
        }
        vetorEmString.append("]");

        return vetorEmString.toString();
    }

}
