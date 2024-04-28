package fila;

public class FilaDinamica<T> {
    private int tamanho;
    private Nodo<T> cabeca;
    private Nodo<T> cauda;
    public FilaDinamica(){
        tamanho=0;
        cabeca=null;
        cauda = null;
    }
    public T desenfileira(){
        if(estaVazia()) throw new Error("Fila vazia");
        T frente = frente();

        cabeca = cabeca.getProximo();
        tamanho--;
        return frente;
    }
    public void enfileira(T elemento){
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if(estaVazia()){
            cabeca = novoNodo;
            cauda = novoNodo;
            tamanho++;
            return;
        }
        if(tamanho()==1){
            cabeca.setProximo(novoNodo);
            cauda = novoNodo;
            tamanho++;
            return;
        }
        cauda.setProximo(novoNodo);
        cauda = novoNodo;
        tamanho++;
    }
    public T frente(){
        if(estaVazia()) return null;
        return cabeca.getElemento();
    }
    public boolean estaVazia(){
        return tamanho()==0;
    }
    public int tamanho(){
        return tamanho;
    }
}
class Nodo<T>{
    T elemento;
    Nodo<T> proximo;
    public Nodo(T elemento){
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
}