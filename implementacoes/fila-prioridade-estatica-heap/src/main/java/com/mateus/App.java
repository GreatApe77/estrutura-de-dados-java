package com.mateus;

import com.mateus.filaPrioridadeHeap.ComparadorPadrao;
import com.mateus.filaPrioridadeHeap.FilaPrioridadeHeap;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        ComparadorPadrao<Integer> comp = new ComparadorPadrao<Integer>();
        System.out.println(comp.compare(70, 80));
        FilaPrioridadeHeap<Integer, String> fila = new FilaPrioridadeHeap<Integer, String>(30);
        fila.insere(50, "Marcos");
        fila.insere(60, "Paulo");//
        fila.insere(50, "Jonas");
        fila.insere(49, "Carlin");//
        fila.insere(1, "Mateus");
        fila.insere(50, "Rafael");
        fila.insere(999, "Maria");//
        fila.insere(61, "Claudio");//
        fila.insere(60, "Fernando");//
        System.out.println(fila.remove());
        System.out.println(fila.remove());
        System.out.println(fila.remove());
        System.out.println(fila.remove());
        // System.out.println(fila.remove());

    }
}
