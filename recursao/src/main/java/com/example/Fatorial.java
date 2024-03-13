package com.example;


public class Fatorial {
    /**
     * Método que calcula o fatorial de um número
     * @param n número desejado
     * @return fatorial de n
     */
    public static int fatorial(int n){
        if(n==0) return 1; //Caso de Parada
        if(n==1) return 1; // Caso de Parada

        return n*fatorial(n-1); //Casos de Recursão. Recursão linear
    }
    

}
