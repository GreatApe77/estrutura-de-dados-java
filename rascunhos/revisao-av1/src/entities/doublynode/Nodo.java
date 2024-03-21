package entities.doublynode;

public class Nodo<T> {
    private T elemento;
    private Nodo<T> anterior;
    private Nodo<T> proximo;

    public Nodo(T elemento) {
        this.proximo = null;
        this.anterior = null;
        this.elemento = elemento;
    }

    public T getElemento() {
        return elemento;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public Nodo<T> getProximo() {
        return proximo;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }

}