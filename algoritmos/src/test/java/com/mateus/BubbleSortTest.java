package com.mateus;
import org.junit.Assert;
import org.junit.Test;

import com.mateus.bubblesort.BubbleSort;
public class BubbleSortTest {
    

    @Test
    public void deveOrdenarUmaLista(){
        int[] lista = new int[] { 88, 23, 3,  99, 1000, 9 };
        BubbleSort.bubbleSort(lista);
        Assert.assertArrayEquals(new int[]{3,9,23,88,99,1000},lista);
    }
}

