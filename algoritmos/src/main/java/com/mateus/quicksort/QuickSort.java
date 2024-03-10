package com.mateus.quicksort;

import java.util.Arrays;

public class QuickSort {
    private static int partition(int[] array,int comeco,int fim){
        int pivot = array[fim];
        int i =comeco-1;
        for (int j = comeco; j <= fim-1 ; j++) {
            if(array[j]<pivot){
                i++;
                int auxiliar = array[i];
                array[i] = array[j];
                array[j] = auxiliar;
            }
        }
        i++;
        int auxiliar = array[i];
        array[i] = array[fim]; //pivot
        array[fim] = auxiliar;
        return i;
    }
    public static void quickSort(int[] array,int comeco,int fim){
        if(fim<=comeco){
            return;
        }
        int pivot = partition(array, comeco, fim);
        quickSort(array, comeco, pivot-1);
        quickSort(array, pivot+1, fim); 
    }
    
    
    public static int _partition(int[] array,int comeco,int fim){
        int pivot = array[fim];
        int i = comeco -1;
        for (int j = comeco; j <= fim-1; j++) {
            if(array[j]>pivot){
                i++;
                int auxiliar = array[j];
                array[j] = array[i];
                array[i] = auxiliar;
            }
        }
        i++;
        int auxiliar = array[i];
        array[i] = array[fim];
        array[fim] = auxiliar;
        return i;
    }
    public static void quickSortDecrescente(int[] array , int comeco , int fim){
        if(fim<=comeco){
            return;
        }
        int pivot = _partition(array, comeco, fim);
        quickSortDecrescente(array, pivot+1, fim);
        quickSortDecrescente(array, comeco, pivot-1); 
    }
    public static void main(String[] args) {
        int[] lista = new int[] { 4, 7, 2, 6, 4, 1, 8, 3,2000,9999,1,2,2,1,333,2,1,55,67,876,8,3 };
        // quickSortCrescente(lista);
        // System.out.println(Arrays.toString(lista));
        // quickSortDecrescente(lista);
        //quickSort(lista, 0, lista.length-1);
        //System.out.println(Arrays.toString(lista));
        //quickSortDecrescente(lista, 0, lista.length-1);
        //System.out.println(Arrays.toString(lista));
    }
}
