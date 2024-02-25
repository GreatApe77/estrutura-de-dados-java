package vetor;

public interface IVetor {
    /**
     * Adiciona um elemento no final do vetor
     * @param elemento elemento a ser adicionado
     * @return true se der certo, false se der errado
     */
    public boolean adicionarElementoNoFinal(int elemento)  ;
    public void adicionarElementoNoComeco(int elemento);
    public boolean adiciona(int posicao, int elemento);
    public void setElementoEmPosicao(int posicao,int elemento);
    public void removerElemento(int posicao);
    public int buscarElementoEmPosicao(int posicao);
    /**
     * Retorna o indice do elemento buscado
     * @param elemento elemento a ser buscado
     * @return o indice do elemento. -1 se nao for encontrado.
     */
    public int indiceDoElemento(int elemento);
    public boolean contemElemento(int elemento);
    public int tamanho();
    public String toString();
    public boolean estaCheio();
    public boolean estaVazio();
}
