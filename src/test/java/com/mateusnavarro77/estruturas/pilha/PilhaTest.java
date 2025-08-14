package com.mateusnavarro77.estruturas.pilha;

import org.junit.Assert;
import org.junit.Test;

public class PilhaTest {

    @Test
    public void testEmpilhar() {
        IPilha<Integer> pilha = new Pilha<Integer>();
        pilha.empilhar(11);
        pilha.empilhar(222);
        pilha.empilhar(333);

        Assert.assertTrue(pilha.tamanho() == 3);
        Assert.assertTrue(pilha.topo() == 333);
    }

    @Test
    public void testDesempilhar() {
        IPilha<Integer> pilha = new Pilha<Integer>();
        Assert.assertTrue(pilha.tamanho() == 0);
        Assert.assertTrue(pilha.estaVazia());
        pilha.empilhar(11);
        Assert.assertFalse(pilha.estaVazia());
        Integer elementoDesempilhado = pilha.desempilhar();
        Assert.assertTrue(elementoDesempilhado == 11);
        Assert.assertTrue(pilha.tamanho() == 0);

    }

}