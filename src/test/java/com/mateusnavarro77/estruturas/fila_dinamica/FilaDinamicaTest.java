package com.mateusnavarro77.estruturas.fila_dinamica;


import org.junit.Assert;
import org.junit.Test;

public class FilaDinamicaTest {
    
    @Test
    public void deveEnfileirarEMostarAFrente(){
        FilaDinamica<Integer> filaDinamica = new FilaDinamica<Integer>();
        filaDinamica.enfileira(40);
        Assert.assertTrue(40==filaDinamica.frente());
        Assert.assertTrue(filaDinamica.tamanho()==1);
        filaDinamica.enfileira(70);
        Assert.assertTrue(filaDinamica.tamanho()==2);
        Assert.assertTrue(40==filaDinamica.frente());
        filaDinamica.enfileira(91);
        Assert.assertTrue(filaDinamica.tamanho()==3);
        Assert.assertTrue(40==filaDinamica.frente());
        Assert.assertEquals("[40, 70, 91]", filaDinamica.toString());
    }
    
    @Test
    public void deveMostrarSeEstaVazia(){
        FilaDinamica<Integer> filaDinamica = new FilaDinamica<Integer>();
        Assert.assertTrue(filaDinamica.tamanho()==0);
        Assert.assertTrue(filaDinamica.estaVazia());
    }
    @Test
    public void deveTestarSeNaoEstaVazia(){
        FilaDinamica<Integer> filaDinamica = new FilaDinamica<Integer>();
        filaDinamica.enfileira(70);
        Assert.assertTrue(filaDinamica.tamanho()==1);
        Assert.assertTrue(filaDinamica.estaVazia()==false);
    }
    @Test
    public void deveDesenfileirar(){
        FilaDinamica<Integer> filaDinamica = new FilaDinamica<Integer>();
        filaDinamica.enfileira(40);
        filaDinamica.enfileira(70);
        Integer elementoDesenfileirado = filaDinamica.desenfileira();
        Assert.assertTrue(elementoDesenfileirado==40);
        Assert.assertTrue(filaDinamica.tamanho()==1);
        Assert.assertTrue(filaDinamica.frente()==70);
        filaDinamica.desenfileira();
        Assert.assertTrue(filaDinamica.estaVazia());
        Assert.assertEquals("[]",filaDinamica.toString());


    }

}