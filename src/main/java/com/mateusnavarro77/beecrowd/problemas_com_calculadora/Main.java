package com.mateusnavarro77.beecrowd.problemas_com_calculadora;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    // posicoes {2 3} {5 6 7} {11 12}

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {

            String linha = scanner.next();
            String[] stringEspacada = linha.split("");
            //System.out.println(Arrays.toString(stringEspacada));
            
            int primeiroNumero = Integer.parseInt(stringEspacada[2]+stringEspacada[3]);
            int segundoNumero = Integer.parseInt(stringEspacada[5]+stringEspacada[6]+stringEspacada[7]);
            int terceiroNumero = Integer.parseInt(stringEspacada[11]+stringEspacada[12]);
            int resultado = primeiroNumero+segundoNumero+terceiroNumero;
            System.out.println(resultado);
        }
        scanner.close();
    }
}