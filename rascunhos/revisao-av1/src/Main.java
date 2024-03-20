import java.util.ArrayList;

import entities.ListaEncadeada;
import entities.ListaEstatica;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        // ListaEstatica<Integer> listaEstatica = new ListaEstatica<Integer>(6);
        ListaEncadeada<Integer> lista = new ListaEncadeada<Integer>();
        for (int i = 1; i <= 10; i++) {
            // listaEstatica.inserir(i);
            lista.inserirFinal(i);
        }
        System.out.println(lista);
    }
}
