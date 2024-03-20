package entities;

public class ListaEstatica<T> {
    private T[] elementos;
    private int tamanho;
    private static  final int CAPACIDADE_PADRAO = 5;
    @SuppressWarnings("unchecked")
    public ListaEstatica(int capacidade){
        
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho=0;    
    }
    @SuppressWarnings("unchecked")
    public ListaEstatica(){
        
        this.elementos = (T[]) new Object[ListaEstatica.CAPACIDADE_PADRAO];
        this.tamanho=0;    
    }
    //ADICIONAR ELEMENTOS
    public void inserir(T elemento){
        if(_estaCheia()){
            throw new Error("Lista cheia");
        }
        this.elementos[tamanho()] = elemento;
        _incrementarTamanho(); 
    }
    public void inserir(int posicao,T elemento){
        if(_estaCheia()){
            throw new Error("Lista cheia");
        }
        if(posicao<0 || posicao>tamanho()){
            throw new IndexOutOfBoundsException();
        }
        if(posicao==tamanho()){
            this.inserir(elemento);
            return;
        }

        for (int i = tamanho()-1; i>=posicao ; i--) {
            this.elementos[i+1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        _incrementarTamanho();


    }

    public int tamanho(){
        return this.tamanho;
    }
    public boolean estaVazia(){
        return this.tamanho()==0;
    }
    private boolean _estaCheia(){
        return tamanho()==elementos.length;
    }
    private void _incrementarTamanho(){
        this.tamanho++;
    }
    @Override
    public String toString() {
        StringBuilder s  = new StringBuilder();
        s.append("[");
        for (int i = 0; i < tamanho(); i++) {
            if(i==tamanho()-1){
                s.append(elementos[i]);
            }else{
                s.append(elementos[i]);
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }
}
