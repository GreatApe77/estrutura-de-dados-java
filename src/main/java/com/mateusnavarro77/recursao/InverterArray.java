package com.mateusnavarro77.recursao;

import java.util.Arrays;

public class InverterArray {
    public static void inverterArray(int[] array){
        int comeco = 0;
        int fim = array.length-1;
        _inverterArray(array, comeco, fim);
    }
    private static void _inverterArray(int[] array,int comeco,int fim){
        if(comeco<fim){
            int aux = array[comeco];
            array[comeco] = array[fim];
            array[fim] = aux;
            _inverterArray(array, comeco+1, fim-1);
        }
    }
    public static void main(String[] args) {
        int[] vetor = new int[]{1,2,3,4,5,6,7,8};
        inverterArray(vetor);
        System.out.println(Arrays.toString(vetor));
    }
}