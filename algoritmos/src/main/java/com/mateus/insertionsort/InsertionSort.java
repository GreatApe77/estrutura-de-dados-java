package com.mateus.insertionsort;

public class InsertionSort {
    public static void insertionSort(int[] list ){
        if(list.length<=1) return;
        for (int i = 1; i < list.length; i++) {
            int pointer = i;
            while (  pointer>=1 && list[pointer]<list[pointer-1]) {
                int aux = list[pointer];
                list[pointer] = list[pointer-1];
                list[pointer-1] = aux;
                pointer--;
            }
        }
    }
}
