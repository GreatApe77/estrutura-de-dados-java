package com.mateus;

import org.junit.Assert;
import org.junit.Test;

import com.mateus.fila.Fila;
import com.mateus.fila.IFila;

public class FilaTest {

    @Test
    public void deveEnfileirar() {
        IFila<Integer> fila = new Fila<Integer>();
        Integer elemento = 999;
        Assert.assertTrue(fila.estaVazia());
        fila.enfileirar(elemento);
        Assert.assertFalse(fila.estaVazia());
        Assert.assertTrue(fila.tamanho()==1);
        Assert.assertEquals(elemento,fila.primeiroDaFila());

    }
    @Test
    public void deveDesenfileirar(){
        IFila<Integer> fila = new Fila<Integer>();
        Integer elemento1 = 999;
        Integer elemento2 = 77;
        fila.enfileirar(elemento1);
        fila.enfileirar(elemento2);
        Assert.assertEquals(elemento1,fila.desenfileirar());
        Assert.assertTrue(fila.tamanho()==1);
        Assert.assertEquals(elemento2,fila.desenfileirar());
        Assert.assertTrue(fila.tamanho()==0);
        Assert.assertTrue(fila.estaVazia());
        
    }
}
