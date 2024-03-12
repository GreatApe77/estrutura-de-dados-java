package com.mateus;

import com.mateus.lista.duplamente.encadeada.ListaDuplamenteEncadeada;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<Integer>();

        lista.adicionarFinal(70);
        lista.adicionar(0, 9);
        lista.adicionar(0, 99);
        lista.adicionar(1, 600);
        lista.adicionarFinal(66);
        lista.adicionarFinal(67);
        lista.adicionarFinal(68);
        lista.removerComeco();
        lista.removerFinal();
        lista.remover(2);
        lista.remover(0);
        lista.remover(2);
        //lista.remover(2);
        System.out.println(lista);
    }
}
