package com.mateus.fibonaccidinamico;

public class FibonacciDinamico {

    public static void main(String[] args) {
        int n = 61;
        int result = fibDinamico(n);
        System.out.println(result);
    }

    /**
     * Wrapper do fib dinamico up bottom
     */
    public static int fibDinamico(int n) {
        int[] memoria = new int[n + 1];

        return _fibDinamico(n, memoria);

    }

    /**
     * Fibonacci (programação dinâmica) up bottom
     * Complexidade: O(n)
     */
    public static int _fibDinamico(int n, int[] memoria) {
        if (memoria[n] == 0 && n <= 1) {
            memoria[n] = n;
            return n;
        }
        if (memoria[n - 1] == 0) {
            memoria[n - 1] = _fibDinamico(n - 1, memoria);
        }
        if (memoria[n - 2] == 0) {
            memoria[n - 2] = _fibDinamico(n - 2, memoria);
        }

        return memoria[n - 1] + memoria[n - 2];

    }

    /**
     * Fibonacci simples
     * Complexidade: O(2^n)
     */
    public static int fibSimples(int n) {
        if (n <= 1) {
            return n;
        }
        return fibSimples(n - 1) + fibSimples(n - 2);

    }
}
