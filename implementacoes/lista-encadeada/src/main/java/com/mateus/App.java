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
        ListaEncadeada<Integer> listaInteiros = new ListaEncadeada<Integer>();
        //listaInteiros.adicionarNoFinal(66);
        //listaInteiros.adicionarNoFinal(7);
        //listaInteiros.adicionarNoFinal(610);
        //listaInteiros.adicionarNoFinal(9);
        //listaInteiros.adicionarNoFinal(3);
        //listaInteiros.adicionarNoFinal(1);
        //listaInteiros.adicionarNoFinal(2);
        //listaInteiros.adicionarNoFinal(610);
        //listaInteiros.adicionarNoFinal(609);
        ListaEncadeada.inserirOrdenado(listaInteiros, 66);
        ListaEncadeada.inserirOrdenado(listaInteiros,7 );
        ListaEncadeada.inserirOrdenado(listaInteiros, 610);
        ListaEncadeada.inserirOrdenado(listaInteiros, 9);
        ListaEncadeada.inserirOrdenado(listaInteiros, 3);
        ListaEncadeada.inserirOrdenado(listaInteiros, 1);
        ListaEncadeada.inserirOrdenado(listaInteiros, 2);
        ListaEncadeada.inserirOrdenado(listaInteiros, 610);
        ListaEncadeada.inserirOrdenado(listaInteiros, 609);
        
        //ListaEncadeada.ordena(listaInteiros);
        System.out.println(listaInteiros.tamanho());
    }
}
