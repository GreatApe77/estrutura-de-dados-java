package filaDePrioridade;

/**
 * Implementacao usando heap de maximo com numeros inteiros
 */
public class FilaPrioridadeHeap {
    private int tamanho;
    private int[] heap;

    public FilaPrioridadeHeap(int capacidade) {
        heap = new int[capacidade];
        tamanho = 0;
    }

    public FilaPrioridadeHeap() {
        this(16);
    }

    public void enfileira(int elemento) {
        if (estaCheia())
            throw new Error("Fila cheia");
        int indiceAtual = tamanho();
        heap[indiceAtual] = elemento;
        while (indiceAtual != 0 && heap[pai(indiceAtual)] < heap[indiceAtual]) {
            swap(pai(indiceAtual), indiceAtual);
            indiceAtual = pai(indiceAtual);
        }
        tamanho++;

    }

    public int desenfileira() {
        if (estaVazia())
            throw new Error("Fila vazia");
        if (tamanho() == 1) {
            tamanho--;
            return heap[0];

        }
        int raiz = frente();
        heap[0] = heap[tamanho()-1];
        tamanho--;
        maxHeapify(0);
        return raiz;
    }
    private void maxHeapify(int indice){
        int maior = indice;
        int filhoEsquerdo = filhoEsquerdo(maior);
        int filhoDireito = filhoDireito(maior);
        if(filhoEsquerdo<tamanho() && heap[filhoEsquerdo]> heap[maior] ){
            maior = filhoEsquerdo;
        }
        if(filhoDireito<tamanho() && heap[filhoDireito]>heap[maior]){
            maior = filhoDireito;
        }

        if(maior!=indice){
            swap(indice,maior);
            maxHeapify(maior);
        }
    }
    public int frente() {
        return heap[0];
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho() == this.heap.length;
    }

    public int tamanho() {
        return tamanho;
    }

    private int pai(int i) {
        return (i - 1) / 2;
    }

    private int filhoEsquerdo(int i) {
        return i * 2 + 1;
    }

    private int filhoDireito(int i) {
        return i * 2 + 2;
    }

    private void swap(int i, int j) {
        int aux = heap[i];
        heap[i] = heap[j];
        heap[j] = aux;
    }
}
