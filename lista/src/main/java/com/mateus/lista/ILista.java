package com.mateus.lista;

public interface ILista<T> {
    /**
     * Retorna o tamanho da lista
     * @return
     */
    public int tamanho();
    /**
     * Adiciona Elemento em determinada posicao
     * @param elemento Elemento a ser adicionado
     * @param posicao Posicao
     */
    public void adicionarElemento(T elemento,int posicao);
    /**
     * Atualiza um elemento na lista
     * @param posicao Posicao do elemento a ser atualizado
     * @param elemento novo Elemento
     */
    public void setElemento(int posicao,T elemento);
    /**
     * Limpa a lista
     */
    public void limpar();
}
