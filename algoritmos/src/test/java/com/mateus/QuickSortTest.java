package com.mateus;
import com.mateus.quicksort.QuickSort;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {
    

    @Test
    public void deveOrdenarCrescente(){
        int[] lista = new int[] { 4, 7, 2, 6, 4, 1,3,3,1 };
        int[] listaEsperada = new int[]{1,1,2,3,3,4,4,6,7};
        QuickSort.quickSort(lista, 0, lista.length-1);
        Assert.assertArrayEquals(listaEsperada, lista);    
    }
    @Test
    public void deveOrdenarDecrescente(){
        int[] lista = new int[] { 4, 7, 2, 6, 4, 1,3,3,1 };
        int[] listaEsperada = new int[]{7,6,4,4,3,3,2,1,1};
        QuickSort.quickSortDecrescente(lista, 0, lista.length-1);
        Assert.assertArrayEquals(listaEsperada, lista);    
    }
}
