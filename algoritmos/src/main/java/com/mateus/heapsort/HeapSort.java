package com.mateus.heapsort;

public class HeapSort {

    public static void heapSort(int[] lista){
        int n = lista.length;
        for (int i = (n/2)-1; i >= 0; i--) {
            _heapify(lista, n, i);
        }

        for (int i = n-1; i >= 0; i--) {
            //Troca do raiz (maior número) com o último elemento do heap
            int raiz = lista[0];
            lista[0] = lista[i];
            lista[i] = raiz;
            _heapify(lista, i, 0); 
        }
    }


    private static void _heapify(int[] lista,int n, int indiceRaiz) {
        int indiceDoMaior = indiceRaiz;
        int filhoEsquerdo = indiceDoMaior * 2 + 1;
        int filhoDireito = indiceDoMaior * 2 + 2;

        if (filhoEsquerdo < n && lista[filhoEsquerdo] > lista[indiceDoMaior]) {
            indiceDoMaior = filhoEsquerdo;
        }
        if (filhoDireito < n && lista[filhoDireito] > lista[indiceDoMaior]) {
            indiceDoMaior = filhoDireito;
        }
        if (indiceRaiz != indiceDoMaior) {
            int temp = lista[indiceDoMaior];
            lista[indiceDoMaior] = lista[indiceRaiz];
            lista[indiceRaiz] = temp;
            _heapify(lista,n, indiceDoMaior);
        }
    }
}
