package com.example;

public class Fibonacci {
    /**
     * Método que calcula o n-ésimo termo da sequência de Fibonacci
     * @param n posição do termo desejado
     * @return n-ésimo termo da sequência de Fibonacci
     */
    public static int fibonacci(int n){
        if(n==0) return 0; // Caso de Parada
        if(n==1) return 1; // Caso de Parada

        return fibonacci(n-1) + fibonacci(n-2); // Caso de Recursão. Recursão Binária
    }
}
