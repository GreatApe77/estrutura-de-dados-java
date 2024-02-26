package vetor;

public interface ILista<T> {

    boolean atualizarElementoEmPosicao(int posicao, T elemento);

    boolean adicionarElementoNoFinal(T elemento);

    boolean removerElemento(T elemento);

    void removerElementoEmPosicao(int posicao);

    T buscarElementoEmPosicao(int posicao);

    int indiceDoElemento(T elemento);
    int ultimoIndiceDoElemento(T elemento);
    boolean contemElemento(T elemento);

    int tamanho();

    String toString();

    void adicionarElementoNoComeco(T elemento);

    boolean estaCheio();

    boolean estaVazio();

    boolean adiciona(int posicao, T elemento);

    void removerElementoDoFinal();
    void limpar();
}