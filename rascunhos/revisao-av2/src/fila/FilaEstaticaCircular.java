package fila;

public class FilaEstaticaCircular<T> {
    private T[] elementos;
    private int indicePrimeiro;
    private int indiceUltimo;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public FilaEstaticaCircular(int capacidade){
        elementos = (T[]) new Object[capacidade];
        tamanho=0;
        indicePrimeiro=0;
        indiceUltimo = 0;
    }
    public void enfileira(T elemento){
        elementos[indiceUltimo] = elemento;
        indiceUltimo = (indiceUltimo+1)%elementos.length;
        tamanho++;
    }
    public T desenfileira(){
        T frente = frente();
        indicePrimeiro = (indicePrimeiro+1)%elementos.length;
        tamanho--;
        return frente;
    }
    public T frente(){
        if(estaVazia()) return null;
        return elementos[indicePrimeiro];
    }
    public boolean estaVazia(){
        return this.tamanho==0;
    }
    public boolean estaCheia(){
        return this.tamanho==this.elementos.length;
    }
    public int tamanho() {
        return this.tamanho;
    }
}
