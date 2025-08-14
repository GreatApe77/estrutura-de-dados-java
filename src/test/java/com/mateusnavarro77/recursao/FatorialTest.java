package com.mateusnavarro77.recursao;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FatorialTest {
    
    @Test
    public void testFatorial(){
        int valorEsperadoParaFatorialDe5 = 120;
        int fatorialCalculado = Fatorial.fatorial(5);
        assertTrue(valorEsperadoParaFatorialDe5==fatorialCalculado);
    }
}