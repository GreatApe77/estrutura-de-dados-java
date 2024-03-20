import java.util.ArrayList;

import entities.ListaEstatica;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        ListaEstatica<Integer> listaEstatica = new ListaEstatica<Integer>(6);
        for (int i = 1; i <= 10; i++) {
            listaEstatica.inserir(i);
        }
        listaEstatica.inserir(0, 99);
        listaEstatica.remover();
        listaEstatica.remover(0);
        listaEstatica.remover(1);
        listaEstatica.remover(7);

        listaEstatica.inserir(77);
        // ArrayList<Integer> arrayList = new ArrayList<>();
        listaEstatica.inserir(78);
        listaEstatica.inserir(77);
        listaEstatica.inserir(79);
        System.out.println(listaEstatica.buscaIndiceDe(77));
        System.out.println(listaEstatica.buscaUltimoIndiceDe(77));
        System.out.println(listaEstatica);
        listaEstatica.limpa();
        System.out.println(listaEstatica);
        // .out.println(listaEstatica.buscaIndiceDe(77));
    }
}
