public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
class FilaEstatica<T> {
    
    private int posicaoInicio;
    private int posicaoFinal;
    private int tamanho;
    private T[] elementos;

    @SuppressWarnings("unchecked")
    public FilaEstatica(int capacidade){
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
        this.posicaoFinal =0;
        this.posicaoInicio = 0;
    }
    public FilaEstatica(){
        this(10);
    }
    public boolean estaVazia(){
        return tamanho()==0;

    }
    public void enfileira(T elemento){
        if(estaCheia())throw new Error("Cheia");
        this.tamanho++;
        this.elementos[posicaoFinal] = elemento;
        posicaoFinal = (posicaoFinal+1)%(this.elementos.length);
    }
    public T desenfileira(){
        T frente = frente();
        this.tamanho--;
        posicaoInicio = (posicaoInicio+1)%(this.elementos.length);
        return frente;
    }
    public T frente(){
        if(estaVazia()) throw new Error("Vazia");
        return this.elementos[posicaoInicio];
    }
    public boolean estaCheia(){
        return this.elementos.length== tamanho();
    }
    public int tamanho() {
        return this.tamanho;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        @SuppressWarnings("unchecked")
        T[] arrayAuxiliar = (T[]) new Object[tamanho()];
        for (int i = 0; i < arrayAuxiliar.length; i++) {
            arrayAuxiliar[i] = this.desenfileira();
            if(i==arrayAuxiliar.length-1){
                s.append(arrayAuxiliar[i]);
            }else{
                s.append(arrayAuxiliar[i]);
                s.append(", ");
            }
        }
        s.append("]");
        for (int i = 0; i < arrayAuxiliar.length; i++) {
            this.enfileira(arrayAuxiliar[i]);
        }
        return s.toString();
    }
}