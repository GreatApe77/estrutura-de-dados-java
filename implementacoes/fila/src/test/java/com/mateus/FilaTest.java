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
}
