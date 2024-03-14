package fila;

public class Fila<T> {
    private T[] elementos;
    private int tamanho;
    
    private static final int CAPACIDADE_PADRAO = 5;
    @SuppressWarnings("unchecked")
    public Fila(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }
    @SuppressWarnings("unchecked")
    public Fila() {
        this.elementos = (T[]) new Object[CAPACIDADE_PADRAO];
        this.tamanho = 0;
    }
    public boolean estaVazia() {
        return this.tamanho == 0;

    }
    public void enfileira(T elemento){
        if(_estaCheia()){
            throw new Error("Fila cheia");
        }
       _adicionarElemento(elemento,this.tamanho);
    }
    public T espiar(){
        return this.elementos[0];
    }
    
    
    private void _adicionarElemento(T elemento, int posicao) {
        //_lancarErroDePosicaoInvalida(posicao);
        //_aumentarCapacidade();
        // inserir x na posicao 4
        // [a b c d e e f] t = 6 i=4
        for (int i = tamanho - 1; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        // [a b c d x e f]
        this.elementos[posicao] = elemento;
        this.tamanho++;
    }
    public T desenfileira(){
        if(this.tamanho==0){
            throw new Error("Fila vazia");
        }
        return _removerPorPosicao(0);
    }
    private T _removerPorPosicao(int posicao) {
        //_lancarErroDePosicaoInvalida(posicao);

        // [a b c e f ]|f] i=4
        T elemento = this.elementos[posicao];
        for (int i = posicao; i < tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        this.tamanho--;
        return elemento;
        
    }

    private boolean _estaCheia() {
        return this.tamanho == this.elementos.length;
    }
    /*
     * private void _aumentaCapacidade() {
     * if (_estaCheia()) {
     * int capacidadeAtual = this.elementos.length;
     * int novaCapacidade = capacidadeAtual * 2;
     * 
     * @SuppressWarnings("unchecked")
     * T[] novoArrayMaior = (T[]) new Object[novaCapacidade];
     * for (int i = 0; i < this.elementos.length; i++) {
     * novoArrayMaior[i] = this.elementos[i];
     * }
     * this.elementos = novoArrayMaior;
     * }
     * }
     */

    @Override
    public String toString() {
        String s = "[";

        for (int i = 0; i < tamanho; i++) {
            if (i == this.tamanho - 1) {
                s = s + this.elementos[i];
            } else {
                s = s + this.elementos[i] + ", ";
            }
        }
        s = s + "]";
        return s;

    }
}
