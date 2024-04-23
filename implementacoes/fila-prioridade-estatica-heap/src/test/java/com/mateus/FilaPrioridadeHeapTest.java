package com.mateus;

import org.junit.Assert;
import org.junit.Test;

import com.mateus.filaPrioridadeHeap.FilaPrioridadeHeap;

public class FilaPrioridadeHeapTest {
    


    @Test
    public void deveInserirComPrioridade(){
        FilaPrioridadeHeap<Integer,String> fila = new FilaPrioridadeHeap<Integer,String>(30);
        fila.insere(50, "Marcos");
        fila.insere(60, "Paulo");
        Assert.assertTrue(fila.frente().getValor().equals("Paulo"));
    }
}
