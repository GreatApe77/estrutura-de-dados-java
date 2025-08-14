package com.mateusnavarro77.estruturas.fila_prioridade_estatica_heap;

/**
 * Interface que define o que é uma fila de prioridade
 */
public interface FilaPrioridade<Chave,Valor> {
    /**
     * Enfileira um elemento
     * @param chave Nível da prioridade
     * @param valor Elemento 
     */
    void insere(Chave chave, Valor valor);
    /**
     * 
     * Retorna o elemento com maior prioridade da fila
     */
    Elemento<Chave,Valor> frente();
    /**
     * Remove o elemento de maior prioridade da fila e retorna ele
     * 
     */
    Elemento<Chave,Valor> remove();
    /**
     * 
     * @return Tamanho da fila
     */
    int tamanho();
    /**
     * 
     * @return false se a fila estiver vazia
     */
    boolean estaVazia();
}