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
        lista.adicionarEmPosicao("Opa", 1);
        lista.adicionarEmPosicao("Sou o 3", 3);

        System.out.println(lista);
        System.out.println(lista.indiceDe("Diaa"));
        lista.limpa();
        System.out.println(lista);
    }
}
