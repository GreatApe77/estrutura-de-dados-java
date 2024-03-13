package com.example;

public class Potenciacao {
    /**
     * Retorna x elevado a n
     * @param x base
     * @param n expoente
     */
    public static int potencia(int x,int n){
        if(n==0){
            return 1; //x^0 = 1 se x nao for zero;
        }
        return x*potencia(x, n-1);
    }
    public static void main(String[] args) {
        System.out.println(potencia(6, 2));
    }
}
