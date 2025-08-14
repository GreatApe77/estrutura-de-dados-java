package com.mateusnavarro77.algoritmos.bubblesort;


public class BubbleSort {

    public static void bubbleSort(int[] listaDesordenada) {
        for (int i = 0; i < listaDesordenada.length; i++) {
            for (int j = 0; j < listaDesordenada.length - 1; j++) {
                if (listaDesordenada[j] > listaDesordenada[j + 1]) {
                    int auxiliar = listaDesordenada[j + 1];
                    listaDesordenada[j + 1] = listaDesordenada[j];
                    listaDesordenada[j] = auxiliar;
                }
            }
        }
    }
}
