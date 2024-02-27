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
     * Adiciona elemento no final da lista
     * @param elemento Elemento a ser adicionado
     */
    public void adicionarElementoNoFinal(T elemento);
    /**
     * Busca um elemento dada a sua posicao
     * @param posicao Posicao
     */
    public T pesquisarPorIndice(int posicao);
    public int pesquisarIndiceDe(T elemento);
    public boolean contem(T elemento);
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
    /**
     * Verifica se a lista esta vazia
     * @return true se vazia
     */
    public boolean estaVazia();
    
}
