package com.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("main");
        //Crescente.crescente(6);
        //Decrescente.decresente(5);
        //int[] meuVetor = {1,2,3,4};
        //System.out.println(SomatorioVetor.somatorioDoVetor(meuVetor));
        //Crescente.crescente(0, 100);
        //System.out.println(Somatorio.somatorio(1));
        //int resultado =SomatorioVetor.somatorioDoVetor(meuVetor, meuVetor.length);
        //System.out.println(resultado);

        
        Scanner scanner = new Scanner(System.in);
        int opcao;
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Fibonacci");
        System.out.println("2 - Fatorial");
        System.out.println("3 - Sair");
        opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Digite o n-ésimo termo da sequência de Fibonacci:");
                int nFib = scanner.nextInt();
                int resultadoFib = Fibonacci.fibonacci(nFib);
                System.out.println("O número na posição " + nFib + " é " +resultadoFib);
                break;
            case 2:
                System.out.println("Digite o número para calcularmos o fatorial:");
                int nFact = scanner.nextInt();
                int resultadoFact = Fatorial.fatorial(nFact);
                System.out.println("O número na posição " + nFact + " é " + resultadoFact);
                break;
            case 3:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Digite um Número Válido...");
                main(args);
                break;
        }
        scanner.close();
 
    }
}
