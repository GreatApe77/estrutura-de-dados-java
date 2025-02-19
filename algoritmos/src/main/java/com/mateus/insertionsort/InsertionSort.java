package com.mateus.insertionsort;

public class InsertionSort {
    public static void insertionSort(int[] list ){
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j = i-1;
            while (  j>=0  &&key<list[j]) {
                list[j+1]= list[j];
                j--;
            }
            list[j+1] = key;
        }
    }
}
