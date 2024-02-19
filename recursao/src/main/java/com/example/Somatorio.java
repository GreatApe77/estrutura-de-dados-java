package com.example;

public class Somatorio {
    public static int somatorio(int n){
        if(n==0) return 0;
        if(n==1) return 1;

        return n+somatorio(n-1);
    }
}
