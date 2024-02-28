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
    /**
     * Retorna a primeira posicao(indice) do elemento se este existir na lista
     * @param elemento Elemento a ser Buscado 
     * @return O indice se ele existir -1 se nao existir
     */
    public int pesquisarIndiceDe(T elemento);
    /**
     * Retorna true se o elemento for encontrado na lista
     * @param elemento Elemento 
     * @return true se existir na lista
     */
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

    /**
     * Remove um elemento dada sua posicao organizando a lista novamente
     * @param posicao
     * @return
     */
    public boolean removerPorPosicao(int posicao);

    /**
     * Busca um elemento e remove da lista
     * @param elemento a ser resolvido
     * @return true se removido
     */
    public boolean removerElemento(T elemento);
    /**
     * Pesquisa a ultima ocorrencia do Elemento na lista
     * @param elemento Elemento
     * @return indice 
     */
    public int pesquisarUltimoIndiceDe(T elemento);
    
}
