package com.mateus.filaPrioridadeHeap;

public interface FilaPrioridade<Chave,Valor> {
    void insere(Chave chave, Valor valor);
    Elemento<Chave,Valor> frente();
    Elemento<Chave,Valor> remove();
    int tamanho();
    boolean estaVazia();
}
