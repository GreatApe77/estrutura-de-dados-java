package com.mateus;

import org.junit.Assert;
import org.junit.Test;

import com.mateus.lista.Lista;

public class ListaTest {

    @Test
    public void deveCriarUmaListaSemPassarParametros() {
        Lista<Integer> lista = new Lista<Integer>();
        Assert.assertTrue("Deve criar uma lista zerada", lista.tamanho() == 0);
    }

    @Test
    public void deveCriarUmaListaComElementosIniciais() {
        Integer[] arrayTeste = new Integer[] { 10, 20, 30, 40 };
        Lista<Integer> lista = new Lista<Integer>(arrayTeste);
        Assert.assertTrue(lista.tamanho() == 4);
        for (int i = 0; i < arrayTeste.length; i++) {
            boolean condicaoValida = lista.pesquisarPorIndice(i) == arrayTeste[i];
            Assert.assertTrue(condicaoValida);
        }

    }

    @Test
    public void deveBuscarUmElementoPorIndice() {
        Integer[] arrayTeste = new Integer[] { 10, 20, 30, 40 };
        Lista<Integer> lista = new Lista<Integer>(arrayTeste);
        Assert.assertTrue(lista.pesquisarPorIndice(0) == arrayTeste[0]);
    }
}
