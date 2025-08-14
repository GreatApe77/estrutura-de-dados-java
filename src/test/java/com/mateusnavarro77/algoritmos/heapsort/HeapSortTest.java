package com.mateusnavarro77.algoritmos.heapsort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class HeapSortTest {

    @Test
    public void ordenaPorHeapSort() {
        int[] listaTeste = { 88, 23, 3, 99, 1000, 9 };
        int[] resultadoEsperado = { 3, 9, 23, 88, 99, 1000 };
        HeapSort.heapSort(listaTeste);
        System.out.println(listaTeste);
        assertArrayEquals(listaTeste, resultadoEsperado);

    }
}