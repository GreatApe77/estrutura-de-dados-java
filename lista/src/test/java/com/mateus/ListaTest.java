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

    @Test
    public void deveVerificarSeEstaVazia() {
        Lista<Integer> lista = new Lista<Integer>();
        Assert.assertTrue(lista.tamanho() == 0);
    }

    @Test
    public void deveAdicionarUmElementoNoFinal() {
        Lista<Integer> lista = new Lista<Integer>();
        Integer elemento = 9999;
        lista.adicionarElementoNoFinal(elemento);
        Assert.assertTrue(lista.tamanho() == 1);

        Assert.assertTrue(lista.pesquisarPorIndice(0) == elemento);
    }

    @Test
    public void deveAdicionarUmElementoNoMeio() {
        Integer[] arrayTeste = new Integer[] { 10, 20, 30, 40 };
        Lista<Integer> lista = new Lista<Integer>(arrayTeste);
        int elemento = 9999;
        lista.adicionarElemento(elemento, 2);
        Assert.assertTrue(lista.pesquisarPorIndice(2) == elemento);
        Assert.assertTrue(lista.pesquisarPorIndice(4)==40);
    }
    @Test
    public void deveRetornarTrueSeAListaEstiverVazia(){
        Lista<Integer> lista = new Lista<Integer>();
        Assert.assertTrue(lista.estaVazia());
    }
    @Test
    public void deveRetornarFalseParaListaNaoVazia(){
        Lista<Integer> lista = new Lista<Integer>();
        int elemento = 123456;
        lista.adicionarElementoNoFinal(elemento);
        Assert.assertFalse(lista.estaVazia());
    }
    @Test
    public void devePesquisarIndiceDeElemento(){
        Integer[] arrayTeste = new Integer[] { 10, 20, 30, 40,5,55,2,2,3,5,70,80 };
        Lista<Integer> lista = new Lista<Integer>(arrayTeste);
        Assert.assertTrue(lista.pesquisarIndiceDe(70)==10);
        
    }
    @Test
    public void deveRetornarMenos1SeNaoExistirElemento(){
        Integer[] arrayTeste = new Integer[] { 10, 20, 30, 40,5,55,2,2,3,5,70,80 };
        Lista<Integer> lista = new Lista<Integer>(arrayTeste);
        Assert.assertTrue(lista.pesquisarIndiceDe(7777)==-1);
        
    }
    @Test 
    public void deveConterElementoNaLista(){
        Integer[] arrayTeste = new Integer[] { 10, 20, 30, 40,5,55,2,2,3,5,70,80 };
        Lista<Integer> lista = new Lista<Integer>(arrayTeste);
        Assert.assertTrue(lista.contem(3));
    }
    public void naoDeveConterElementoNaLista(){
        Integer[] arrayTeste = new Integer[] { 10, 20, 30, 40,5,55,2,2,3,5,70,80 };
        Lista<Integer> lista = new Lista<Integer>(arrayTeste);
        Assert.assertFalse(lista.contem(9999));
        
    }
}
