package com.mateus;

import com.mateus.lista.encadeada.ListaEncadeada;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("Bom");
        lista.adicionarNoFinal("Dia");
        System.out.println(lista);
    }
}
