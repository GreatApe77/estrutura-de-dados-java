package vetor;

public class Lista<T> implements ILista<T> {
    private T[] elementos;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public Lista(int capacidadeTotal) {
        this.elementos = (T[]) new Object[capacidadeTotal];

        this.tamanho = 0;
    }

    public Lista(T[] elementosIniciais) {
        this.elementos = elementosIniciais;
        this.tamanho = elementosIniciais.length;
    }

    @SuppressWarnings("unchecked")
    public Lista() {
        this.elementos = (T[]) new Object[5];
        this.tamanho = 0;
    }

    private void aumentaCapacidade() {
        if (estaCheio()) {
            @SuppressWarnings("unchecked")
            T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
            for (int i = 0; i < this.tamanho; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    @Override
    public boolean atualizarElementoEmPosicao(int posicao, T elemento) {
        if (!(posicao >= 0 && posicao < this.tamanho))
            throw new IllegalArgumentException("Posicao Invalida");
        setElementoEmPosicao(posicao, elemento);
        return true;
    };

    @Override
    public boolean adicionarElementoNoFinal(T elemento) {
        aumentaCapacidade();
        int posicao = this.tamanho;
        this.setElementoEmPosicao(posicao, elemento);
        this.tamanho++;
        return true;
    }

    private void setElementoEmPosicao(int posicao, T elemento) {
        elementos[posicao] = elemento;
    }

    @Override
    public boolean removerElemento(T elemento) {
        int indice = indiceDoElemento(elemento);
        if (indice == -1)
            return false;
        removerElementoEmPosicao(indice);
        return true;
    }

    @Override
    public void removerElementoEmPosicao(int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho))
            throw new IllegalArgumentException("Posicao Invalida");

        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        this.tamanho--;
    }

    @Override
    public T buscarElementoEmPosicao(int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho))
            throw new IllegalArgumentException("Posicao Invalida");
        return this.elementos[posicao];
    }

    @Override
    public int indiceDoElemento(T elemento) {
        // busca sequencial nao otimizada
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contemElemento(T elemento) {
        // busca sequencial nao otimizada
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int tamanho() {
        return this.tamanho;
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
    public void adicionarElementoNoComeco(T elemento) {
        adiciona(0, elemento);
    }

    @Override
    public boolean estaCheio() {
        return tamanho == this.elementos.length;
    }

    @Override
    public boolean estaVazio() {
        return tamanho == 0;
    }

    @Override
    public boolean adiciona(int posicao, T elemento) {
        if (!(posicao >= 0 && posicao < this.tamanho))
            throw new IllegalArgumentException("Posicao Invalida");
        this.aumentaCapacidade();
        for (int i = this.tamanho - 1; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;
        return true;
    }

    @Override
    public void removerElementoDoFinal() {
        removerElementoEmPosicao(this.tamanho - 1);
    }
}
