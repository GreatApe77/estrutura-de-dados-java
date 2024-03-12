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
        System.out.println(lista);
    }
}
