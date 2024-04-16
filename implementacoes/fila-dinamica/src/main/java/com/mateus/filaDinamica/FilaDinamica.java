package com.mateus.filaDinamica;

public class FilaDinamica<T> {
    private int tamanho;
    private Nodo<T> cabeca;
    private Nodo<T> cauda;
    
    public boolean estaVazia(){
        return tamanho()==0;
    }
    
    public T frente(){
        if(estaVazia()) throw new Error("Fila Vazia");
        return this.cabeca.getElemento();
    }
    public void enfileira(T elemento){
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if(estaVazia()){
            this.cabeca = novoNodo;
            this.cauda = novoNodo;
            this.tamanho++;
            return;
        }
        if(tamanho()==1){
            this.cabeca.setProximoNodo(novoNodo);
            this.cauda = novoNodo;
            this.tamanho++;
            return;
        }
        this.cauda.setProximoNodo(novoNodo);
        this.cauda = novoNodo;
        this.tamanho++;

    }
    public T desenfileira(){
        return null;
    }
    public int tamanho(){
        return this.tamanho;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");

        Nodo<T> atual = this.cabeca;

        while (atual!=null) {
            if(atual.getProximoNodo()==null){
                s.append(atual.getElemento());
                
            }else{
                s.append(atual.getElemento());
                s.append(", ");
            }
            atual = atual.getProximoNodo();
        }
        s.append("]");
        return s.toString();
    }
    
}
