package vetor;

public interface IVetor {
    public void adicionarElementoNoFinal(int elemento);
    public void adicionarElementoNoComeco(int elemento);
    public void adicionarElementoEmPosicao(int posicao,int elemento);
    public void removerElemento(int posicao);
    public int buscarElementoEmPosicao(int posicao);
    public int indiceDoElemento(int indice);
    public int tamanho();
    public String toString();
}
