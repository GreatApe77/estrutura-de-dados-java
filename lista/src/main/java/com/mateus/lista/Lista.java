package com.mateus.lista;

public class Lista<T> implements ILista<T> {
    private T[] elementos; 
    private int tamanho; 
    private int tamanhoPadrao = 5; 
    public Lista(int capacidade){

    }
    public Lista(T[] elementosIniciais){

    }
    public Lista(){

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setElemento'");
    }

    @Override
    public void limpar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'limpar'");
    }

}
