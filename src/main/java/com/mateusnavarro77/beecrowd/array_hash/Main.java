package com.mateusnavarro77.beecrowd.array_hash;

import java.io.IOException;
import java.util.Scanner;
import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) throws IOException {
        
        TabelaHash<Integer,Integer> tabela = new TabelaHash<Integer,Integer>();
        int valor =0;
        for (int i = (int) 'A'; i <= (int) 'Z'; i++) {
            tabela.insere(i,valor);
            valor++;
        }
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int valorHash=0;
            int L = scanner.nextInt();
            for (int j = 0; j < L; j++) {
                String[] linha = scanner.next().split("");
                for (int k = 0; k < linha.length; k++) {
                    valorHash+= tabela.busca( (int) linha[k].charAt(0)).getValor() + j+k; 
                }                
            }
            System.out.println(valorHash);
        }
        scanner.close();
    }
}

interface Dicionario<K, V> {
    void insere(K chave, V valor);

    Entrada<K, V> busca(K chave);

    Entrada<K, V> remove(K chave);

    int tamanho();

    boolean estaVazia();
}

 
 class TabelaHash<K extends Comparable<K>, V> implements Dicionario<K, V> {

    private int tamanho;
    private ListaDuplamenteEncadeada<Entrada<K, V>>[] tabela;

    @SuppressWarnings("unchecked")
    public TabelaHash(int capacidade) {

        this.tabela = (ListaDuplamenteEncadeada<Entrada<K, V>>[]) Array.newInstance(ListaDuplamenteEncadeada.class,
                capacidade);
        this.tamanho = 0;
    }

    public TabelaHash() {
        this(37);
    }

    @Override
    public void insere(K chave, V valor) {
        int indice = hash(chave);
        Entrada<K, V> entrada = new Entrada<K, V>(chave, valor);
        if (tabela[indice] == null) {
            ListaDuplamenteEncadeada<Entrada<K, V>> listaAuxiliar = new ListaDuplamenteEncadeada<Entrada<K, V>>();
            listaAuxiliar.adicionarFinal(entrada);
            tabela[indice] = listaAuxiliar;
        } else {
            tabela[indice].adicionarFinal(entrada);
        }
        this.tamanho++;
    }

    @Override
    public Entrada<K, V> busca(K chave) {
        int indice = hash(chave);
        if(tabela[indice]==null){
            return null;
        }
        
        Nodo<Entrada<K,V>> atual = tabela[indice].primeiro;
        while (atual!=null) {
            if(atual.getElemento().getChave().compareTo(chave)==0){
                //as chaves foram iguais
                return atual.getElemento();
            }
            atual = atual.getProximo();
        }
        return null;
    }

    @Override
    public Entrada<K, V> remove(K chave) {
        int indice = hash(chave);
        if(tabela[indice]==null){
            return null;
        }
        ListaDuplamenteEncadeada<Entrada<K,V>> lista = tabela[indice];
        Nodo<Entrada<K,V>> atual = lista.primeiro;
        Entrada<K,V> removido = null;
        while (atual!=null) {
            if(atual.getElemento().getChave().compareTo(chave)==0){
                if(atual==lista.primeiro){
                    removido = atual.getElemento();
                    lista.removerComeco();
                    return removido;
                }
                if(atual==lista.ultimo){
                    removido = atual.getElemento();
                    lista.removerFinal();
                    return removido;
                }
                removido = atual.getElemento();
                atual.getAnterior().setProximo(atual.getProximo());
                atual.getProximo().setAnterior(atual.getAnterior());
                lista.tamanho--;
                return removido;
            }
            atual = atual.getProximo();
        }
        return removido;
    }

    @Override
    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public boolean estaVazia() {
        return this.tabela.length == 0;
    }

    public int hash(K chave) {
        if (chave instanceof Integer) {
            return (Integer) chave % this.tabela.length;
        }
        throw new IllegalArgumentException("Chave Invalida");
    }

    @Override
    public String toString() {
        int cap = 2 + tamanho() + (2 * (tamanho() - 1));

        StringBuilder s = new StringBuilder(cap);
        s.append("[");
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] != null) {

                if (i == tamanho() - 1) {
                    s.append(tabela[i].toString());
                } else {
                    s.append(tabela[i].toString());
                    s.append(tabela[i].toString());
                    s.append(", ");
                }
            }
        }
        s.append("]");
        return s.toString();
    }

}
class Nodo<T>{
    private Nodo<T> anterior;
    private Nodo<T> proximo;
    private T elemento;
    
    public Nodo(T elemento){
        this.anterior = null;
        this.proximo = null;
        this.elemento = elemento;
    }

    public T getElemento() {
        return elemento;
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
    public Nodo<T> getAnterior() {
        return anterior;
    }
    public Nodo<T> getProximo() {
        return proximo;
    }
}
class ListaDuplamenteEncadeada<T> {
    
    protected int tamanho;
    protected Nodo<T> primeiro;
    public Nodo<T> ultimo;

    public ListaDuplamenteEncadeada(){
        this.tamanho= 0;
        this.primeiro = null;
        this.ultimo = null;
    }
    public int tamanho(){
        return this.tamanho;
    }
    public void adicionarComeco(T elemento){
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if(this.tamanho==0){
            this.primeiro = novoNodo;
            this.ultimo = novoNodo;
        }else{
            primeiro.setAnterior(novoNodo);
            novoNodo.setProximo(primeiro);
            primeiro = novoNodo;
        }
        this.tamanho++;
    }
    public void adicionarFinal(T elemento){
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        if(this.tamanho==0){
            this.primeiro = novoNodo;
            this.ultimo = novoNodo;
        }else{
            this.ultimo.setProximo(novoNodo);
            novoNodo.setAnterior(this.ultimo);
            this.ultimo = novoNodo;
        }
        this.tamanho++;
    }
    public void adicionar(int posicao, T elemento){
        if(posicao<0 || posicao>this.tamanho){
            throw new IndexOutOfBoundsException("Posicao invalida");
        }
        
        if(posicao==0){
            this.adicionarComeco(elemento);
            return;
        }
        if(posicao == this.tamanho-1){
            this.adicionarFinal(elemento);
            return;
        }
        Nodo<T> novoNodo = new Nodo<T>(elemento);
        
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao-1; i++) {
            atual = atual.getProximo();
        }
        novoNodo.setAnterior(atual);
        novoNodo.setProximo(atual.getProximo());
        atual.getProximo().setAnterior(novoNodo);
        atual.setProximo(novoNodo);

        this.tamanho++;
        
    }

    public void removerComeco(){
        if(this.tamanho==0){
            throw new IndexOutOfBoundsException("Lista esta vazia");

        }
        if(this.tamanho==1){
            this.primeiro =null;
            this.ultimo =null;
        }else {
            
            this.primeiro = primeiro.getProximo();
            this.primeiro.setAnterior(null);
        }
        this.tamanho--;
    }

    public void removerFinal(){
        if(this.tamanho==0){
            throw new IndexOutOfBoundsException("Lista esta vazia");

        }
        if(this.tamanho==1){
            this.primeiro =null;
            this.ultimo =null;
        }else{
            this.ultimo = this.ultimo.getAnterior();
            this.ultimo.setProximo(null);
        }
        this.tamanho--;
    }
    public void remover(int posicao){
        if(posicao<0 || posicao>=this.tamanho){
            throw new IndexOutOfBoundsException("Posicao invalida");
        }
        if(posicao==0){
            this.removerComeco();
            return;
        }
        if(posicao==this.tamanho-1){
            this.removerFinal();
            return;
        }

        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao-1; i++) {
            
            atual = atual.getProximo();
        }
        atual.getProximo().getProximo().setAnterior(atual);
        atual.setProximo(atual.getProximo().getProximo());
        this.tamanho--;
    }

    public void set(int posicao,T elemento){
        if(posicao<0 || posicao>=this.tamanho){
            throw new IndexOutOfBoundsException("Posicao invalida");
        }
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        atual.setElemento(elemento);
    }
    public T get(int posicao){
        if(posicao<0 || posicao>=this.tamanho){
            throw new IndexOutOfBoundsException("Posicao invalida");
        }
        Nodo<T> atual = this.primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual.getElemento();
    }
   
    @Override
    public String toString() {
        
        StringBuilder s = new StringBuilder();
        s.append("[");
        Nodo<T> atual = this.primeiro;
        while (atual!=null) {
            if(atual==ultimo){
                s.append(atual.getElemento());
            }else{
                s.append(atual.getElemento());
                s.append(", ");
            }
            atual = atual.getProximo();
        }
        s.append("]");
        return s.toString();
    }
}
class Entrada<K, V> {
    private K chave;
    private V valor;

    public Entrada(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }

    public void setChave(K chave) {
        this.chave = chave;
    }

    public K getChave() {
        return chave;
    }

    public V getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Entrada [chave=" + chave + ", valor=" + valor + "]";
    }

}