package com.example;
import java.io.IOException;
import java.util.Scanner;

class Fibonacci {
    int quantidadeDeChamadas = 0;
    
    public void _preencherArray(int[] array,int i){
        if(i==array.length){
            return;
        }
        array[i] = -77;
        _preencherArray(array, i+1);
    }
    public int calcularFibonacci(int n){
        int[] cacheDeN = new int[39];
        int i = 0;
        _preencherArray(cacheDeN, i);
        cacheDeN[0] = 0;
        cacheDeN[1] = 1;
        return  _calcularFibonacci(n, cacheDeN);
        
    }
    public int _calcularFibonacci(int n,int[] cacheDeN) {
        this.quantidadeDeChamadas++;
        if(cacheDeN[n]!=-77){
            return cacheDeN[n];
        }
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        cacheDeN[n] =  _calcularFibonacci(n - 1,cacheDeN) + _calcularFibonacci(n - 2,cacheDeN);

        return cacheDeN[n];

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
    private static void _entradaDeDados(int i, int numeroCasosDeTeste,Scanner scanner,Fibonacci fibonacci){
        if(i==numeroCasosDeTeste ){
            return;
        }
        int x = scanner.nextInt();
        int resultado = fibonacci.calcularFibonacci(x);
        printarFormatado(x, fibonacci.getQuantidadeDeChamadas(), resultado);
        fibonacci.resetarContador();
        _entradaDeDados(i+1, numeroCasosDeTeste, scanner, fibonacci);
    }
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Fibonacci fibonacci = new Fibonacci();
        int numeroCasosDeTeste = scanner.nextInt();
        int i = 0;
        _entradaDeDados(i, numeroCasosDeTeste, scanner, fibonacci);
        
        scanner.close();

    }
}
