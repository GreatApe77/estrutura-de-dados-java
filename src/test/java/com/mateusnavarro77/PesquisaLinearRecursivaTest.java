package com.mateusnavarro77;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mateusnavarro77.algoritmos.pesquisalinearrecursiva.PesquisaLinearRecursiva;

public class PesquisaLinearRecursivaTest {
    int[] vetor = new int[]{6,4,23,5,7,34,5,568,45,346,34,32,432,233,4234,6,7,4};
    
    @Test
    public void pesquisaLinear(){
        int valorProcurado = 568;
        int indiceEsperado = 7;
        int resultado = PesquisaLinearRecursiva.pesquisaLinearRecursiva(vetor, valorProcurado);
        assertEquals(indiceEsperado, resultado);
    }
    @Test
    public void pesquisaLinearNaoEncontrado(){
        int valorProcurado = 888;
        int indiceEsperado = -1; //nao encontrado
        int resultado = PesquisaLinearRecursiva.pesquisaLinearRecursiva(vetor, valorProcurado);
        assertEquals(indiceEsperado, resultado);
    }
}
