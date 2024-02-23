package com.example;

import java.util.Scanner;

class Fibonacci {
    int quantidadeDeChamadas = 0;

    public int calcularFibonacci(int n) {
        this.quantidadeDeChamadas++;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);

    }

    public int getQuantidadeDeChamadas() {
        return quantidadeDeChamadas-1;
    }

    public void resetarContador() {
        this.quantidadeDeChamadas = 0;
    }
}

public class Main {

    public static void printarFormatado(int entrada, int chamadas, int resultado) {
        System.out.println("fib(" + entrada + ") = " + chamadas + " calls = " + resultado);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fibonacci fibonacci = new Fibonacci();
        int numeroCasosDeTeste = scanner.nextInt();
        
        for (int i = 0; i < numeroCasosDeTeste; i++) {
            int x = scanner.nextInt();
            int resultado = fibonacci.calcularFibonacci(x);
            printarFormatado(x, fibonacci.getQuantidadeDeChamadas(), resultado);
            fibonacci.resetarContador();
            
        }
        
        scanner.close();

    }
}
