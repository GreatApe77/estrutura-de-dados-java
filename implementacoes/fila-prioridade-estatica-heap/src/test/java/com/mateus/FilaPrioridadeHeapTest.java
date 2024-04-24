package com.mateus;

import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

import com.mateus.filaPrioridadeHeap.Elemento;
import com.mateus.filaPrioridadeHeap.FilaPrioridadeHeap;

public class FilaPrioridadeHeapTest {
    

    //quero descrever o teste para aparecer no terminal
    @Test
    
    public void deveInserirComPrioridade(){
        FilaPrioridadeHeap<Integer,String> fila = new FilaPrioridadeHeap<Integer,String>(30);
        fila.insere(50, "Marcos");
        fila.insere(60, "Paulo");
        Assert.assertTrue(fila.frente().getValor().equals("Paulo"));
    }

    @Test
    public void casoDeTesteCurioso(){
        FilaPrioridadeHeap<Integer, String> fila = new FilaPrioridadeHeap<Integer, String>(30);
        PriorityQueue<Pessoa> filaDoJava = new PriorityQueue<>(30, new PessoaComparator());
        //9 elementos em cada fila
        fila.insere(50, "Marcos");
        fila.insere(60, "Paulo");
        fila.insere(50, "Jonas");
        fila.insere(49, "Carlin");
        fila.insere(1, "Mateus");
        fila.insere(50, "Rafael");
        fila.insere(999, "Maria");//
        fila.insere(61, "Claudio");
        fila.insere(60, "Fernando");
        filaDoJava.add(new Pessoa("Marcos", 50));
        filaDoJava.add(new Pessoa("Paulo", 60));
        filaDoJava.add(new Pessoa("Jonas", 50));
        filaDoJava.add(new Pessoa("Carlin", 49));
        filaDoJava.add(new Pessoa("Mateus", 1));
        filaDoJava.add(new Pessoa("Rafael", 50));
        filaDoJava.add(new Pessoa("Maria", 999));
        filaDoJava.add(new Pessoa("Claudio", 61));
        filaDoJava.add(new Pessoa("Fernando", 60));
        int tamanhoFila = fila.tamanho();
        int tamanhoFilaDoJava = filaDoJava.size();
        Assert.assertTrue(tamanhoFila==tamanhoFilaDoJava);
        for (int i = 0; i < tamanhoFila; i++) {
            Pessoa pessoaRemovidaJava = filaDoJava.remove();
            Elemento<Integer,String> pessoaRemovidaHeap = fila.remove();
            Assert.assertTrue(pessoaRemovidaHeap.getValor().equals(pessoaRemovidaJava.getNome()));
            Assert.assertTrue(pessoaRemovidaHeap.getChave().equals(pessoaRemovidaJava.prioridade));
        }
    }

}
