package com.mateus.quicksort;

import java.util.Arrays;

public class QuickSort {
    private static int _partition(int[] array, int inicio, int fim) {
        int pivot = array[fim];
        int i = inicio;
        for (int j = inicio; j <fim; j++) {
            if(array[j]<=pivot){
                int auxiliar = array[j];
                array[j] = array[i];
                array[i] = auxiliar;
                i++;
            }
        }
        int auxiliar = array[i];
        array[i] = array[fim];
        array[fim] = auxiliar;
        return i;
    }

    public static void _quickSort(int[] array, int inicio, int fim) {
        if (fim == -1) {
            fim = array.length - 1;
        }
        if (inicio < fim) {
            int posicaoPivot = _partition(array, inicio, fim);
            _quickSort(array, inicio, posicaoPivot - 1);
            _quickSort(array, posicaoPivot + 1, fim);
        }
    }

    public static void quickSort(int[] array) {
        int inicio = 0;
        int fim = -1;
        _quickSort(array, inicio, fim);

    }

    public static void main(String[] args) {
        int[] lista = new int[] { 4, 7, 2, 6, 4, 1, 8, 3 };
        quickSort(lista);
        System.out.println(Arrays.toString(lista));
    }
}
