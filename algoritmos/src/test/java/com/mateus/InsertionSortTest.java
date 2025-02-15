package com.mateus;

import org.junit.Assert;
import org.junit.Test;

import com.mateus.insertionsort.InsertionSort;

public class InsertionSortTest {
    @Test
    public void shouldOrder() {
        int[] before = new int[] { 4, 7, 2, 6, 4, 1, 3, 3, 1 };
        int[] expectedAfter = new int[] { 1, 1, 2, 3, 3, 4, 4, 6, 7 };
        InsertionSort.insertionSort(before);
        Assert.assertArrayEquals(before, expectedAfter);
    }
}
