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
        // lista.inserirFinal(80);
        // lista.inserirFinal(77);
        // lista.inserirComeco(66);
        lista.insereOrdenado(75);
        lista.insereOrdenado(7);
        lista.insereOrdenado(1);
        lista.insereOrdenado(2);
        lista.insereOrdenado(70);
        lista.insereOrdenado(111);
        lista.insereOrdenado(99);
        // lista.removerComeco();
        lista.removerPosicao(2);
        lista.removerFinal();
        lista.inserirComeco(9999);
        // for (int i = 0; i < 6; i++) {
        // lista.removerFinal();
        // }
        lista.limpa();
        System.out.println(lista);
    }
}
