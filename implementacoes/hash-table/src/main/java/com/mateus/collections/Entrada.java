package com.mateus.collections;

public class Entrada<K, V> {
    private K chave;
    private V valor;

    public Entrada(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    public void setChave(K chave) {
        this.chave = chave;
    }

    public K getChave() {
        return chave;
    }

    public V getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Entrada [chave=" + chave + ", valor=" + valor + "]";
    }

}
