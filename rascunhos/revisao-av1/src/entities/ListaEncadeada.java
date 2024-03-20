package entities;

class Nodo<T> {
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

/**
 * LinkedList normal
 */
public class ListaEncadeada<T> {
    protected Nodo<T> primeiro;
    protected Nodo<T> ultimo;
    protected int tamanho;

    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho=0;
    }
    public void inserirFinal(T elemento){
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if(estaVazia()){
            this.primeiro = novoNodo;
            this.ultimo = novoNodo;
            _incrementarTamanho();
            return;
        }
        if(tamanho()==1){
            this.primeiro.setProximo(novoNodo);
            this.ultimo = novoNodo;
            _incrementarTamanho();
            return;
        }

        this.ultimo.setProximo(novoNodo);
        this.ultimo = novoNodo;
        _incrementarTamanho();
    }
    public int tamanho() {
        return this.tamanho;
    }
    public boolean estaVazia(){
        return tamanho()==0;

    }
    private void _incrementarTamanho() {
        this.tamanho++;
    }

    @Override
    public String toString() {
        String s = "[";
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < tamanho(); i++) {
            if(i==tamanho()-1){
                s = s + atual.getElemento();
            }
            else{
                s = s+ atual.getElemento()+", ";
            }
            atual = atual.getProximo();
        }
        s = s +"]";
        return s;
    }
}
