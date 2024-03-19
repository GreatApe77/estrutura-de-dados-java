package com.mateus;

import com.mateus.lista.encadeada.ListaEncadeada;

/**
 * Hello world!
 *
 */
public class App {
    
    public static void main(String[] args) {

        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        //lista.insereOrdenado("Bom");
        //lista.insereOrdenado("Dia");
        //lista.insereOrdenado("Inicio");
        //lista.insereOrdenado("Opa");
        //lista.insereOrdenado("Sou o 3");
        lista.insereOrdenado(77);
        lista.insereOrdenado(78);
        lista.insereOrdenado(3);
        lista.insereOrdenado(1);
        lista.insereOrdenado(50);
        System.out.println(lista);
        
    
    }
}
