package com.example;

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
