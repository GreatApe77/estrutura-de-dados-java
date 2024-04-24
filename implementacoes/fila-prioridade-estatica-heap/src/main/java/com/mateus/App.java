package com.mateus;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.mateus.filaPrioridadeHeap.FilaPrioridadeHeap;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // ComparadorPadrao<Integer> comp = new ComparadorPadrao<Integer>();
        // System.out.println(comp.compare(70, 80));
        FilaPrioridadeHeap<Integer, String> fila = new FilaPrioridadeHeap<Integer, String>(30);
        PriorityQueue<Pessoa> fila2 = new PriorityQueue<>(30, new PessoaComparator());
        
        fila.insere(50, "Marcos");
        fila.insere(60, "Paulo");
        fila.insere(50, "Jonas");
        fila.insere(49, "Carlin");
        fila.insere(1, "Mateus");
        fila.insere(50, "Rafael");
        fila.insere(999, "Maria");//
        fila.insere(61, "Claudio");
        fila.insere(60, "Fernando");
        /*
         * fila.insere(1, "Marcos");
         * fila.insere(1, "Geraldo");
         * fila.insere(1, "Carla");
         * System.out.println(fila.remove());
         * System.out.println(fila.remove());
         * System.out.println(fila.remove());
         */

        // Maria
        // Claudio
        // Paulo
        // Fernando
        // Marcos
        // Jonas
        // Rafael
        // Carlin
        // Mateus
        System.out.println(fila.remove());
        System.out.println(fila.remove());
        System.out.println(fila.remove());
        System.out.println(fila.remove());
        System.out.println(fila.remove());
        System.out.println(fila.remove());
        System.out.println(fila.remove());
        System.out.println(fila.remove());
        System.out.println(fila.remove());
        System.out.println("=".repeat(50));
        fila2.add(new Pessoa("Marcos", 50));
        fila2.add(new Pessoa("Paulo", 60));
        fila2.add(new Pessoa("Jonas", 50));
        fila2.add(new Pessoa("Carlin", 49));
        fila2.add(new Pessoa("Mateus", 1));
        fila2.add(new Pessoa("Rafael", 50));
        fila2.add(new Pessoa("Maria", 999));
        fila2.add(new Pessoa("Claudio", 61));
        fila2.add(new Pessoa("Fernando", 60));
        System.out.println(fila2.remove());
        System.out.println(fila2.remove());
        System.out.println(fila2.remove());
        System.out.println(fila2.remove());
        System.out.println(fila2.remove());
        System.out.println(fila2.remove());
        System.out.println(fila2.remove());
        System.out.println(fila2.remove());
        System.out.println(fila2.remove());
        // Pessoa[] pessoas = new Pessoa[2];
        // pessoas[0] = new Pessoa("Geralt",60);
        // pessoas[1] = new Pessoa("Ciri",25);
        // swap(pessoas);
        // System.out.println(Arrays.toString(pessoas));
        //int a = 1;
        //int b =2;
        //System.out.println(a/b);
    }

    public static void swap(Pessoa[] pessoas) {
        Pessoa temp = pessoas[0];
        pessoas[0] = pessoas[1];
        pessoas[1] = temp;
    }
}

class PessoaComparator implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa arg0, Pessoa arg1) {
        if (arg0.getPrioridade() > arg1.getPrioridade())
            return -1;
        if (arg0.getPrioridade() == arg1.getPrioridade())
            return 0;
        return 1;
    }

}

class Pessoa {
    String nome;
    Integer prioridade;

    public Pessoa(String nome, int prioridade) {
        this.nome = nome;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }
    // @Override
    // public int compare(Pessoa arg0, Pessoa arg1) {
    // if(arg0.getPrioridade()>arg1.getPrioridade()) return 1;
    // if(arg0.getPrioridade()==arg1.getPrioridade()) return 0;
    // return -1;
    // }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", prioridade=" + prioridade + "]";
    }
    
}