package pilha;

public class PilhaDinamica<T> {
    private int tamanho;
    private Nodo<T> cabeca;
    private Nodo<T> cauda;

    public PilhaDinamica() {
        cabeca = null;
        cauda = null;
        tamanho = 0;

    }

    public void empilha(T elemento) {
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if (estaVazia()) {
            cabeca = novoNodo;
            cauda = novoNodo;
            tamanho++;
            return;
        }
        if (tamanho() == 1) {
            novoNodo.setAnterior(cabeca);
            cabeca.setProximo(novoNodo);
            cauda = novoNodo;
            tamanho++;
            return;
        }
        novoNodo.setAnterior(cauda);
        cauda.setProximo(novoNodo);
        cauda = novoNodo;
        tamanho++;
    }

    public T desempilha() {
        T topo = topo();
        if (tamanho() == 1) {
            cabeca = null;
            cauda = null;
            tamanho--;
            return topo;
        }
        cauda = cauda.getAnterior();
        cauda.setProximo(null);
        tamanho--;
        return topo;
    }

    public T topo() {
        if (estaVazia())
            return null;
        return cauda.getElemento();
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return tamanho() == 0;
    }

    @Override
    public String toString() {
        int cap = 2 + tamanho() + (2 * (tamanho() - 1)); // 2 parenteses + tamanho da pilha + ", " para cada elemento
                                                         // menos o ultimo
        StringBuilder s = new StringBuilder(cap);
        s.append("[");
        Nodo<T> atual = cabeca;
        while (atual != null) {
            if (atual.getProximo() == null) {
                s.append(atual.getElemento());

            } else {
                s.append(atual.getElemento());
                s.append(", ");
            }
            atual = atual.getProximo();
        }
        s.append("]");
        return s.toString();

    }
}

class Nodo<T> {
    private T elemento;
    private Nodo<T> proximo;
    private Nodo<T> anterior;

    public Nodo(T elemento) {
        this.elemento = elemento;
    }

    public T getElemento() {
        return elemento;
    }

    public Nodo<T> getProximo() {
        return proximo;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }
}