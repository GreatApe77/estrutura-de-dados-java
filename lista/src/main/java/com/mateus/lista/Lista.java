package com.mateus.lista;

public class Lista<T> implements ILista<T> {
    private T[] elementos;
    private int tamanho;
    private int tamanhoPadrao = 5;

    @SuppressWarnings("unchecked")
    public Lista(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
    }

    public Lista(T[] elementosIniciais) {
        this.elementos = elementosIniciais;
        this.tamanho = elementosIniciais.length;
    }

    @SuppressWarnings("unchecked")
    public Lista() {
        this.elementos = (T[]) new Object[this.tamanhoPadrao];
    }

    @Override
    public int tamanho() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tamanho'");
    }

    @Override
    public void adicionarElemento(T elemento, int posicao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarElemento'");
    }

    @Override
    public void setElemento(int posicao, T elemento) {
        
    }

    @Override
    public void limpar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'limpar'");
    }

    //privados
    private boolean _posicaoValida(int posicao){
        return posicao>=0 && posicao<tamanho;
    }
    private void _lancarErroDePosicaoInvalida(int posicao) throws IllegalAccessException{
        if(!_posicaoValida(posicao)) throw new IllegalArgumentException("Tentando acessar posicao invalida");
    }
}
