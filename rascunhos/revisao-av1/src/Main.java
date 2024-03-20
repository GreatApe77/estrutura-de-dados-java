import java.util.ArrayList;

import entities.ListaEstatica;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        ListaEstatica<Integer> listaEstatica = new ListaEstatica<Integer>(20);
        for (int i = 1; i <= 10; i++) {
            listaEstatica.inserir(i);
        }
        listaEstatica.inserir(0, 99);
        listaEstatica.remover();
        listaEstatica.remover(0);
        listaEstatica.remover(1);
        listaEstatica.remover(7);
        // ArrayList<Integer> arrayList = new ArrayList<>();
        
        System.out.println(listaEstatica);
        // .out.println(listaEstatica.buscaIndiceDe(77));
    }
}
