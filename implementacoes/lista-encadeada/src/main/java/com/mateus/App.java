package com.mateus;

import com.mateus.lista.encadeada.ListaEncadeada;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("Bom");
        lista.adicionarNoFinal("Dia");
        lista.adicionarNoComeco("Inicio");
        System.out.println(lista.get(1));
        System.out.println(lista);
    }
}
