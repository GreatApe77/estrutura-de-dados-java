package com.mateus;

import java.util.Arrays;

import com.mateus.filaPrioridadeHeap.ComparadorPadrao;
import com.mateus.filaPrioridadeHeap.FilaPrioridadeHeap;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        //ComparadorPadrao<Integer> comp = new ComparadorPadrao<Integer>();
        //System.out.println(comp.compare(70, 80));
        FilaPrioridadeHeap<Integer, String> fila = new FilaPrioridadeHeap<Integer, String>(30);
        
          fila.insere(50, "Marcos");
          fila.insere(60, "Paulo");
          fila.insere(50, "Jonas");
          fila.insere(49, "Carlin");
          fila.insere(1, "Mateus");
          fila.insere(50, "Rafael");
          fila.insere(999, "Maria");//
          fila.insere(61, "Claudio");
          fila.insere(60, "Fernando");
         System.out.println();
        /* fila.insere(1, "Marcos");
        fila.insere(1, "Geraldo");
        fila.insere(1, "Carla");
        System.out.println(fila.remove());
        System.out.println(fila.remove());
        System.out.println(fila.remove()); */

        //Maria
        //Claudio
        //Paulo
        //Fernando
        //Marcos
        //Jonas
        //Rafael
        //Carlin
        //Mateus
         System.out.println(fila.remove());
         System.out.println(fila.remove());
         System.out.println(fila.remove());
         System.out.println(fila.remove());
         System.out.println(fila.remove());
         System.out.println(fila.remove());
         System.out.println(fila.remove());
         System.out.println(fila.remove());
         System.out.println(fila.remove());

        Pessoa[] pessoas = new Pessoa[2];
        pessoas[0] = new Pessoa("Geralt",60);
        pessoas[1] = new Pessoa("Ciri",25);
        swap(pessoas);
        System.out.println(Arrays.toString(pessoas));
    }
    public static void swap(Pessoa[] pessoas){
        Pessoa temp = pessoas[0];
        pessoas[0] = pessoas[1];
        pessoas[1] = temp;
    }
}


class Pessoa{
    String nome;
    int idade;

    public Pessoa(String nome,int idade){
        this.nome=nome;
        this.idade = idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public String getNome() {
        return nome;
    }
    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + "]";
    }
    
}