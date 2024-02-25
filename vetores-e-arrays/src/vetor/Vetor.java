package vetor;

import java.util.Arrays;

public class Vetor implements IVetor {
    private int[] elementos;
    private int tamanho;
    private int capacidadeTotal;

    public Vetor(int capacidadeTotal) {
        this.elementos = new int[capacidadeTotal];
        this.capacidadeTotal = capacidadeTotal;
        this.tamanho = 0;
    }

    @Override
    public boolean adicionarElementoNoFinal(int elemento) {
        if (estaCheio())
            return false;
        int posicao = this.tamanho;
        this.adicionarElementoEmPosicao(posicao, elemento);
        this.tamanho++;
        return true;
    }

    @Override
    public void adicionarElementoEmPosicao(int posicao, int elemento) {
        elementos[posicao] = elemento;
    }

    @Override
    public void removerElemento(int posicao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerElemento'");
    }

    @Override
    public int buscarElementoEmPosicao(int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho))
            throw new IllegalArgumentException("Posicao Invalida");
        return this.elementos[posicao];
    }

    @Override
    public int indiceDoElemento(int elemento) {
        //busca sequencial nao otimizada
         for (int i = 0; i < this.tamanho; i++) {
            if(this.elementos[i]==elemento){
                return i;
            }
        } 
        return -1;
    }
    @Override
    public boolean contemElemento(int elemento) {
        //busca sequencial nao otimizada 
        for (int i = 0; i < this.tamanho; i++) {
            if(this.elementos[i]==elemento){
                return true;
            }
        }
        return false;
    }
    @Override
    public int tamanho() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tamanho'");
    }

    @Override
    public String toString() {
        StringBuilder arrayString = new StringBuilder();
        arrayString.append("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
            arrayString.append(this.elementos[i]);
            arrayString.append(", ");

        }
        if (this.tamanho > 0) {
            arrayString.append(this.elementos[this.tamanho - 1]); // ultimo elemento
        }
        arrayString.append("]");
        return arrayString.toString();
    }

    @Override
    public void adicionarElementoNoComeco(int elemento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarElementoNoComeco'");
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public boolean estaCheio() {
        return tamanho == capacidadeTotal;
    }

    @Override
    public boolean estaVazio() {
        return tamanho == 0;
    }
}
