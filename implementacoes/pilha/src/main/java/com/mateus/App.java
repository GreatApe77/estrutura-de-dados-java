package com.mateus;

import com.mateus.pilha.IPilha;
import com.mateus.pilha.Pilha;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        IPilha<Integer> pilha = new Pilha<Integer>();
        System.out.println(pilha.tamanho());
        pilha.empilhar(5);
        System.out.println(pilha.tamanho());
        pilha.desempilhar();
        System.out.println(pilha.tamanho());
        pilha.empilhar(999);
        pilha.empilhar(666);
        System.out.println(pilha);
    }
}
