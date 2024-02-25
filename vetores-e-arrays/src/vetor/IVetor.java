package vetor;

public interface IVetor {
    /**
     * Adiciona um elemento no final do vetor
     * @param elemento elemento a ser adicionado
     * @return true se der certo, false se der errado
     */
    public boolean adicionarElementoNoFinal(int elemento)  ;
    public void adicionarElementoNoComeco(int elemento);
    public void adicionarElementoEmPosicao(int posicao,int elemento);
    public void removerElemento(int posicao);
    public int buscarElementoEmPosicao(int posicao);
    public int indiceDoElemento(int indice);
    public int tamanho();
    public String toString();
    public boolean estaCheio();
    public boolean estaVazio();
}
