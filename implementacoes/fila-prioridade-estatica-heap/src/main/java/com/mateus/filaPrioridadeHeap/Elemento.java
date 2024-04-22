package com.mateus.filaPrioridadeHeap;


public interface Elemento<Chave,Valor> {
    /**
     * Método para buscar a chave do elemento na fila de Prioridade.
     * A chave funciona como o nível de prioridade do elemento
     * @return Retorna a Chave do elemento
     */
    Chave getChave();
    /**
     * Retorna o elemento genérico armazenado.
     * @return O valor do elemento propriamente dito
     */
    Valor getValor();
}
