package entities.singlenode;

public class Nodo<T> {
    private T elemento;
    private Nodo<T> proximo;

    public Nodo(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    public Nodo<T> getProximo() {
        return proximo;
    }

    public T getElemento() {
        return elemento;
    }

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
}
