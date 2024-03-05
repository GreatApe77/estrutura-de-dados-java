package com.mateus;

import org.junit.Assert;
import org.junit.Test;

import com.mateus.lista.encadeada.ListaEncadeada;

public class ListaEncadeadaTest {
    

    @Test
    public void deveTransformarAListaParaString(){
        ListaEncadeada<String> lista = new ListaEncadeada<String>();
        lista.adicionarNoFinal("Bom");
        lista.adicionarNoFinal("Dia");
        Assert.assertEquals("[Bom, Dia]",lista.toString());
    }
}
