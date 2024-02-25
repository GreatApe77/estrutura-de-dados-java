package vetor;

import java.util.Arrays;

public class Vetor implements IVetor {
    private int[] elementos;
    private int numeroDeElementos;

    public Vetor(int capacidadeTotal) {
        this.elementos = new int[capacidadeTotal];
        this.numeroDeElementos = 0;
    }

    @Override
    public void adicionarElementoNoFinal(int elemento) {
        int posicao = this.numeroDeElementos;
        this.adicionarElementoEmPosicao(posicao, elemento);
        this.numeroDeElementos++;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarElementoEmPosicao'");
    }

    @Override
    public int indiceDoElemento(int indice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indiceDoElemento'");
    }

    @Override
    public int tamanho() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tamanho'");
    }

    @Override
    public String toString() {
        return Arrays.toString(this.elementos);
    }

    @Override
    public void adicionarElementoNoComeco(int elemento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarElementoNoComeco'");
    }

    public int getNumeroDeElementos() {
        return numeroDeElementos;
    }
}
