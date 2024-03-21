package entities;

import entities.singlenode.Nodo;

/**
 * LinkedList normal
 */
public class ListaEncadeada<T> implements ILista<T> {
    protected Nodo<T> primeiro;
    protected Nodo<T> ultimo;
    protected int tamanho;

    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho=0;
    }
    
   
    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
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
    @Override
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
    @Override
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
    @Override
    public void removerPosicao(int posicao){
        if(posicao<0|| posicao >=tamanho()) throw new IndexOutOfBoundsException();
        if(estaVazia()) throw new Error("Lista Vazia");
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao-1; i++) {
            atual = atual.getProximo();
        }
        atual.setProximo(atual.getProximo().getProximo());
        _decrementarTamanho();
    }
    @Override
    public T get(int posicao){
        return _get(posicao).getElemento();
    }
    private Nodo<T> _get(int posicao){
        if(posicao<0|| posicao >=tamanho()) throw new IndexOutOfBoundsException();
        if(estaVazia()) throw new Error("Lista Vazia");
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }
    @Override
    public void removerComeco(){

        if(estaVazia()) throw new Error("Lista vazia");
        if(tamanho()==1){
            this.primeiro=null;
            this.ultimo = null;
            _decrementarTamanho();
            return;
        }
        this.primeiro = this.primeiro.getProximo();
        _decrementarTamanho();
    }
    @Override
    public void removerFinal(){
        if(estaVazia()) throw new Error("Lista vazia");
        if(tamanho()==1){
            this.primeiro=null;
            this.ultimo = null;
            _decrementarTamanho();
            return;
        }
        Nodo<T> penultimo = _get(tamanho()-2);
        penultimo.setProximo(null);
        this.ultimo = penultimo;
        _decrementarTamanho();
    }
    @Override
    public void limpa(){
        this.primeiro =null;
        this.ultimo = null;
        this.tamanho =0;
    }
    @Override
    public int tamanho() {
        return this.tamanho;
    }
    @Override
    public boolean estaVazia(){
        return tamanho()==0;

    }
    private void _incrementarTamanho() {
        this.tamanho++;
    }
    private void _decrementarTamanho(){
        this.tamanho--;
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
