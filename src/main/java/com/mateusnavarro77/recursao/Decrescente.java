package com.mateusnavarro77.recursao;

public class Decrescente {
    public static void decresente(int n){

        if(n==0){
            System.out.println(0);
            return;
        }
        System.out.println(n);
        decresente(n-1);
    }
}