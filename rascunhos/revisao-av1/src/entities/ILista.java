package entities;

public interface ILista<T> {

    void insereOrdenado(T elemento);

    void inserirComeco(T elemento);

    void inserirFinal(T elemento);

    void removerPosicao(int posicao);

    T get(int posicao);

    void removerComeco();

    void removerFinal();

    void limpa();

    int tamanho();

    boolean estaVazia();

    String toString();

}