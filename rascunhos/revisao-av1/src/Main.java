import java.util.ArrayList;

import entities.ListaEstatica;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        ListaEstatica<Integer> listaEstatica = new ListaEstatica<Integer>(20);
        listaEstatica.inserir(6);
        listaEstatica.inserir(77);
        listaEstatica.inserir(2);
        listaEstatica.inserir(1, 999);
        // ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.println(listaEstatica);
    }
}
