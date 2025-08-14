package com.mateusnavarro77.recursao;

import java.util.HashMap;

public class Fibonacci {
    /**
     * Método que calcula o n-ésimo termo da sequência de Fibonacci
     * 
     * @param n posição do termo desejado
     * @return n-ésimo termo da sequência de Fibonacci
     */
    public static int fibonacci(int n) {
        if (n == 0)
            return 0; // Caso de Parada
        if (n == 1)
            return 1; // Caso de Parada

        return fibonacci(n - 1) + fibonacci(n - 2); // Caso de Recursão. Recursão Binária
    }

    public static int fibonacciOtimizado(int n) {
        HashMap<Integer, Integer> memoria = new HashMap<Integer, Integer>();
        return _fibonacciOtimizado(memoria, n);
    }

    public static int _fibonacciOtimizado(HashMap<Integer, Integer> memoria, int n) {
        if (memoria.get(n) != null) {
            return memoria.get(n);
        }
        if (n == 0) {
            memoria.put(n, 0);
            return 0;
        }
        if (n == 1) {
            memoria.put(n, 1);
            return 1;
        }
        memoria.put(n, _fibonacciOtimizado(memoria, n - 1) + _fibonacciOtimizado(memoria, n - 2));
        return memoria.get(n);

    }

    public static void main(String[] args) {
        System.out.println(fibonacciOtimizado(70));
    }
}