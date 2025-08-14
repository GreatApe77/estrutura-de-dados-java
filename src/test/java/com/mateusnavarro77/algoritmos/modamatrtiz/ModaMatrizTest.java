package com.mateusnavarro77.algoritmos.modamatrtiz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ModaMatrizTest {
    
    @Test
    public void verificaModa(){
        int[][] matriz = {
            {5,34,4},
            {9,6,43},
            {2,9,9},
        };

        int resultado = ModaMatriz.modaMatriz(matriz);
        assertEquals(9,resultado );
    }
}