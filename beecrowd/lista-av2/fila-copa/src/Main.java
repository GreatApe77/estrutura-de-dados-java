import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] mapaDeIdExcluso = new boolean[100001];
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        int N = scanner.nextInt();
        String[] linha = scanner.next().split(" ");
        int M = scanner.nextInt();
        String[] linha2 = scanner.next().split(" ");
        for (int i = 0; i < M; i++) {
            mapaDeIdExcluso[Integer.parseInt(linha2[i])] = true;
        }
        String filaEmTexto = "";
        //int numeroIteracoes = N-M;
        for (int i = 0; i < linha.length; i++) {
            if(mapaDeIdExcluso[Integer.parseInt(linha[i])]==false){
                
                
                    filaEmTexto+=linha[i];
                    filaEmTexto+=" ";
                
            }
        }
        System.out.println(filaEmTexto.strip());
        scanner.close();
        /* Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        int N = scanner.nextInt();
        //Lista<Integer> listaPrincipal = new Lista<Integer>(N);
        String[] linha = scanner.next().split(" ");
        for (int i = 0; i < linha.length; i++) {
         //   listaPrincipal.adicionarElementoNoFinal(Integer.parseInt(linha[i]));
        }

        int M =scanner.nextInt();
        String[] linha2 = scanner.next().split(" ");
        for (int i = 0; i < M; i++) {
          //  listaPrincipal.removerElemento(Integer.parseInt(linha2[i]));
        }
        String filaEmTexto = "";
        for (int i = 0; i < listaPrincipal.tamanho(); i++) {
            if(i==listaPrincipal.tamanho()-1){
                filaEmTexto+= listaPrincipal.pesquisarPorIndice(i);
            }else{
                filaEmTexto+= listaPrincipal.pesquisarPorIndice(i);
                filaEmTexto+=" ";
            }
        }
        System.out.println(filaEmTexto);
        scanner.close();
    } */
}
class Nodo<T> {
    private T elemento;
    private Nodo<T> proximoNodo;

    public Nodo(T elemento){
        this.elemento = elemento;
    }

    public T getElemento() {
        return elemento;
    }
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    public void setProximoNodo(Nodo<T> proximoNodo) {
        this.proximoNodo = proximoNodo;
    }
    public Nodo<T> getProximoNodo() {
        return this.proximoNodo;
    }
}
class FilaDinamica<T> {
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
        T frente = frente();
        if(tamanho()==1){
            this.cabeca =null;
            this.cauda = null;
            this.tamanho--;
            return frente;
        }
        this.cabeca = cabeca.getProximoNodo();
        this.tamanho--;
        return frente;
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
    
}}