package com.mateus;

import com.mateus.lista.Lista;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Integer[] arrayTeste = new Integer[] { 10, 20, 30, 40, 92 };
        Lista<Integer> lista = new Lista<Integer>();
        lista.adicionarElementoNoFinal(1000);
        lista.adicionarElemento(500, 0);
        System.out.println(lista);
    }
}
