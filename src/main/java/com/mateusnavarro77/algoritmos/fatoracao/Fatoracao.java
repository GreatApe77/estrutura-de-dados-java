package com.mateusnavarro77.algoritmos.fatoracao;

import java.util.LinkedList;
import java.util.Queue;

public class Fatoracao {
    public static void fatoracao(int n) {
        Queue<Integer> fila = new LinkedList<Integer>();
        for (int i = 2; i < n / i; i++) {
            while (n % i == 0) {
                fila.add(i);
                n = n / i;
            }
        }
        if (n > 1) {
            fila.add(n);
        }
        int size = fila.size();
        for (int i = 0; i < size; i++) {
            System.out.println(fila.remove());
        }
    }

    public static void main(String[] args) {
        fatoracao(3960);
    }
}
