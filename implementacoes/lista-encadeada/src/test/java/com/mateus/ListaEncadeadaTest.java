package com.mateus;

import org.junit.Assert;
import org.junit.Test;

import com.mateus.lista.encadeada.ListaEncadeada;

public class ListaEncadeadaTest {

    @Test
    public void deveTransformarAListaParaString() {
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("Bom");
        lista.adicionarNoFinal("Dia");
        Assert.assertEquals("[Bom, Dia]", lista.toString());
    }

    @Test
    public void deveAdicionarNoFinal(){
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("Oi");
        Assert.assertTrue(lista.tamanho()==1);
    }

    @Test 
    public void deveAdicionarNoComeco(){
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoComeco("1");
        lista.adicionarNoComeco("2");
        Assert.assertTrue(lista.tamanho()==2);
        Assert.assertEquals("[2, 1]",lista.toString());
    }
    @Test
    public void deveRetornarElemento(){
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("A");
        lista.adicionarNoFinal("B");
        lista.adicionarNoFinal("C");
        String element = lista.get(1);
        Assert.assertEquals("B",element);
    }
    @Test
    public void deveAdicionarNoMeio(){
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("A");
        lista.adicionarNoFinal("B");
        lista.adicionarNoFinal("C");
        String elemento = "MEIO";
        lista.adicionarEmPosicao(elemento, 1);
        String retornado = lista.get(1);
        Assert.assertEquals(elemento,retornado);
        String listaString =lista.toString();
        Assert.assertEquals("[A, MEIO, B, C]",listaString);
    }

    @Test
    public void deveRemoverDoFinal(){
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("A");
        lista.adicionarNoFinal("B");
        lista.adicionarNoFinal("C");
        lista.removerFinal();
        Assert.assertTrue(lista.tamanho()==2);
        String listaString = lista.toString();
        Assert.assertEquals("[A, B]",listaString);
    }
    @Test
    public void deveRemoverDoComeco(){
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("A");
        lista.adicionarNoFinal("B");
        lista.adicionarNoFinal("C");
        lista.removerComeco();
        Assert.assertTrue(lista.tamanho()==2);
        String listaString = lista.toString();
        Assert.assertEquals("[B, C]",listaString);
    }
}
