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
    public void deveAdicionarNoFinal() {
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("Oi");
        Assert.assertTrue(lista.tamanho() == 1);
    }

    @Test
    public void deveAdicionarNoComeco() {
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoComeco("1");
        lista.adicionarNoComeco("2");
        Assert.assertTrue(lista.tamanho() == 2);
        Assert.assertEquals("[2, 1]", lista.toString());
    }

    @Test
    public void deveRetornarElemento() {
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("A");
        lista.adicionarNoFinal("B");
        lista.adicionarNoFinal("C");
        String element = lista.get(1);
        Assert.assertEquals("B", element);
    }

    @Test
    public void deveAdicionarNoMeio() {
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("A");
        lista.adicionarNoFinal("B");
        lista.adicionarNoFinal("C");
        String elemento = "MEIO";
        lista.adicionarEmPosicao(elemento, 1);
        String retornado = lista.get(1);
        Assert.assertEquals(elemento, retornado);
        String listaString = lista.toString();
        Assert.assertEquals("[A, MEIO, B, C]", listaString);
    }

    @Test
    public void deveRemoverDoFinal() {
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("A");
        lista.adicionarNoFinal("B");
        lista.adicionarNoFinal("C");
        lista.removerFinal();
        Assert.assertTrue(lista.tamanho() == 2);
        String listaString = lista.toString();
        Assert.assertEquals("[A, B]", listaString);
    }
    @Test
    public void deveRemoverCorretamenteQuandoExistirApenasUmElemento(){
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("A");
        Assert.assertTrue(lista.tamanho()==1);
        lista.removerFinal();
        Assert.assertTrue(lista.tamanho()==0);
        Assert.assertEquals("[]", lista.toString());
    }

    @Test
    public void deveRemoverDoComeco() {
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("A");
        lista.adicionarNoFinal("B");
        lista.adicionarNoFinal("C");
        lista.removerComeco();
        Assert.assertTrue(lista.tamanho() == 2);
        String listaString = lista.toString();
        Assert.assertEquals("[B, C]", listaString);
    }

    @Test
    public void deveRemoverEmPosicao() {
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("A");
        lista.adicionarNoFinal("B");
        lista.adicionarNoFinal("C");
        lista.removerEmPosicao(1);
        Assert.assertTrue(lista.tamanho() == 2);
        String listaString = lista.toString();
        Assert.assertEquals("[A, C]", listaString);
    }

    @Test
    public void deveRetornarOIndiceDadoElemento() {
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("A");
        lista.adicionarNoFinal("B");
        lista.adicionarNoFinal("C");
        int indiceDeB = lista.indiceDe("B");
        Assert.assertTrue(indiceDeB == 1);
    }

    @Test
    public void deveLimparUmaLista() {
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("A");
        lista.adicionarNoFinal("B");
        lista.adicionarNoFinal("C");
        lista.limpa();
        String listaVaziaEmString = lista.toString();

        Assert.assertTrue(lista.tamanho() == 0);
        Assert.assertEquals(listaVaziaEmString,"[]");
    }
    @Test
    public void deveOrdenarListaDeInteiros(){
        //[1, 2, 3, 7, 9, 66, 609, 610, 610]
        ListaEncadeada<Integer> listaInteiros = new ListaEncadeada<Integer>();
        listaInteiros.adicionarNoFinal(66);
        listaInteiros.adicionarNoFinal(7);
        listaInteiros.adicionarNoFinal(610);
        listaInteiros.adicionarNoFinal(9);
        listaInteiros.adicionarNoFinal(3);
        listaInteiros.adicionarNoFinal(1);
        listaInteiros.adicionarNoFinal(2);
        listaInteiros.adicionarNoFinal(610);
        listaInteiros.adicionarNoFinal(609);
        ListaEncadeada.ordena(listaInteiros);
        String listaEmString = listaInteiros.toString();
        Assert.assertEquals("[1, 2, 3, 7, 9, 66, 609, 610, 610]",listaEmString);
    }
    @Test 
    public void deveInserirOrdenado(){
        ListaEncadeada<Integer> listaInteiros = new ListaEncadeada<Integer>();
        ListaEncadeada.inserirOrdenado(listaInteiros, 66);
        ListaEncadeada.inserirOrdenado(listaInteiros,7 );
        ListaEncadeada.inserirOrdenado(listaInteiros, 610);
        ListaEncadeada.inserirOrdenado(listaInteiros, 9);
        ListaEncadeada.inserirOrdenado(listaInteiros, 3);
        ListaEncadeada.inserirOrdenado(listaInteiros, 1);
        ListaEncadeada.inserirOrdenado(listaInteiros, 2);
        ListaEncadeada.inserirOrdenado(listaInteiros, 610);
        ListaEncadeada.inserirOrdenado(listaInteiros, 609);
        String listaEmString = listaInteiros.toString();
        Assert.assertTrue(listaInteiros.tamanho()==9);
        Assert.assertEquals("[1, 2, 3, 7, 9, 66, 609, 610, 610]",listaEmString);


    }
}
