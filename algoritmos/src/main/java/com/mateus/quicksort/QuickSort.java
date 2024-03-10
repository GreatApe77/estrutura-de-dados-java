package com.mateus.quicksort;

import java.util.Arrays;

public class QuickSort {
    /*
     * private static int _partition(int[] array, int inicio, int fim) {
     * int pivot = array[fim];
     * int i = inicio;
     * for (int j = inicio; j <fim; j++) {
     * if(array[j]<=pivot){
     * int auxiliar = array[j];
     * array[j] = array[i];
     * array[i] = auxiliar;
     * i++;
     * }
     * }
     * int auxiliar = array[i];
     * array[i] = array[fim];
     * array[fim] = auxiliar;
     * return i;
     * }
     * 
     * public static void _quickSort(int[] array, int inicio, int fim) {
     * if (fim == -1) {
     * fim = array.length - 1;
     * }
     * if (inicio < fim) {
     * int posicaoPivot = _partition(array, inicio, fim);
     * _quickSort(array, inicio, posicaoPivot - 1);
     * _quickSort(array, posicaoPivot + 1, fim);
     * }
     * }
     * 
     * public static void quickSort(int[] array) {
     * int inicio = 0;
     * int fim = -1;
     * _quickSort(array, inicio, fim);
     * 
     * }
     */
    public static int _partitionCrescente(int[] array, int start, int end) {

        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            if (array[j] < pivot) {
                i++;
                int aux = array[i];
                array[i] = array[j];
                array[j] = aux;

            }
        }
        i++;
        int aux = array[i];
        array[i] = array[end];
        array[end] = aux;
        return i;
    }

    public static void _quickSortCrescente(int[] array, int start, int end) {
        if (end <= start) {
            return;
        }
        int pivot = _partitionCrescente(array, start, end);
        _quickSortCrescente(array, start, pivot - 1);
        _quickSortCrescente(array, pivot + 1, end);
    }

    public static void quickSortCrescente(int[] array) {
        int start = 0;
        int end = array.length - 1;
        _quickSortCrescente(array, start, end);
    }

    public static int _partitionDecrescente(int[] array, int start, int end) {

        int pivot = array[end];
        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            if (array[j] > pivot) {
                i++;
                int aux = array[i];
                array[i] = array[j];
                array[j] = aux;

            }
        }
        i++;
        int aux = array[i];
        array[i] = array[end];
        array[end] = aux;
        return i;
    }

    public static void _quickSortDecrescente(int[] array, int start, int end) {
        if (end <= start) {
            return;
        }
        int pivot = _partitionDecrescente(array, start, end);
        _quickSortDecrescente(array, start, pivot - 1);
        _quickSortDecrescente(array, pivot + 1, end);
    }

    public static void quickSortDecrescente(int[] array) {
        int start = 0;
        int end = array.length - 1;
        _quickSortDecrescente(array, start, end);
    }

    public static void main(String[] args) {
        int[] lista = new int[] { 4, 7, 2, 6, 4, 1, 8, 3 };
        quickSortCrescente(lista);
        System.out.println(Arrays.toString(lista));
        quickSortDecrescente(lista);
        System.out.println(Arrays.toString(lista));

    }
}
