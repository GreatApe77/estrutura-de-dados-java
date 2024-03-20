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
    
    public void insereOrdenado(T elemento){
        //Comparable == 0
        // Comparable > 1
        //Comparable < -1
        //Nodo<T> novoNodo = new Nodo<T>(elemento);
        if(this.primeiro==null||((Comparable) elemento).compareTo(this.primeiro.getElemento())==-1 ||((Comparable) elemento).compareTo(this.primeiro.getElemento())==0){
            inserirComeco(elemento);
            return;
        }else if((((Comparable) elemento).compareTo(this.ultimo.getElemento())==1)||((Comparable) elemento).compareTo(this.ultimo.getElemento())==0){
            inserirFinal(elemento);
            return;
        }
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        Nodo<T> atual = this.primeiro;
        while (atual.getProximo()!=null && (((Comparable) elemento).compareTo(atual.getProximo().getElemento())==1) ) {
            atual = atual.getProximo();
        }
        novoNodo.setProximo(atual.getProximo());
        atual.setProximo(novoNodo);
        _incrementarTamanho();
    }
    public void inserirComeco(T elemento){
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if(estaVazia()){
            this.primeiro = novoNodo;
            this.ultimo = novoNodo;
            _incrementarTamanho(); 
            return;
        }
        if(tamanho()==1){
            novoNodo.setProximo(this.primeiro);
            this.primeiro=novoNodo;
            _incrementarTamanho();
            return;
            //this.primeiro.setProximo(primeiro);
            //novoNodo.setProximo(this.primeiro);
            //this.primeiro = novoNodo;
            //_incrementarTamanho();
        }
        
        novoNodo.setProximo(this.primeiro);
        this.primeiro = novoNodo;
        _incrementarTamanho();
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
