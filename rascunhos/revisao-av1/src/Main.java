import java.util.ArrayList;

import entities.ListaEncadeada;
import entities.ListaEstatica;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ListaEstatica<Integer> listaEstatica = new ListaEstatica<Integer>(6);
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        // for (int i = 1; i <= 10; i++) {
        // listaEstatica.inserir(i);
        // lista.inserirFinal(i);
        // }
        //lista.inserirFinal(80);
        //lista.inserirFinal(77);
        //lista.inserirComeco(66);
            lista.insereOrdenado(77);
            lista.insereOrdenado(7);
            lista.insereOrdenado(1);
            lista.insereOrdenado(2);
            lista.insereOrdenado(77);
            lista.insereOrdenado(77);
            lista.insereOrdenado(99);
            

        System.out.println(lista);
    }
}
