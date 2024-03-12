package com.mateus;

import com.mateus.lista.duplamente.encadeada.ListaDuplamenteEncadeada;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada<Integer> lista = new ListaDuplamenteEncadeada<Integer>();
        lista.adicionarComeco(6);
        lista.adicionarComeco(1);
        System.out.println(lista);
    }
}
