package com.mateusnavarro77.estruturas.fila_prioridade_estatica_heap;

import java.util.Comparator;

/*
 * Classe que serve para tornar a comparação entre elementos mais genéricas
 */
public class ComparadorPadrao<Chave> implements Comparator<Chave> {

    /**
     *
     * @param chaveA Chave a ser comparada
     * @param chaveB Chave a ser comparada
     * @returns 1 se chave A > B (maior prioridade)
     * @returns 0 se chave A == B (mesma prioridade)
     * @returns -1 se chave A < B (menor prioridade)
     * 
     */
    @SuppressWarnings("unchecked")
    @Override
    public int compare(Chave chaveA, Chave chaveB) {

        return ((Comparable<Chave>) chaveA).compareTo(chaveB);
    }

}