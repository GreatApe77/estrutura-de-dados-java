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
        
        System.out.println(lista.get(1));
        System.out.println(lista);
        lista.removerComeco();
        System.out.println(lista);
    }
}
