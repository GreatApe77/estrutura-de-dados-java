package fatoracao;

import fila.FilaDinamica;

public class Fatoracao {

    public static void fatoracao(int n) {
        FilaDinamica<String> fila = new FilaDinamica<String>();
        for (int i = 2; i < n / i; i++) {
            while (n % i == 0) {
                fila.enfileira(Integer.toString(i));
                n = n / i;
            }
        }
        if (n > 1) {
            fila.enfileira(Integer.toString(n));
        }
        int tamanho = fila.tamanho();
        StringBuilder s = new StringBuilder((tamanho * 2) - 1);
        for (int i = 0; i < tamanho; i++) {
            if (i == tamanho - 1) {
                s.append(fila.desenfileira());
            } else {
                s.append(fila.desenfileira());
                s.append("*");
            }
        }
        System.out.println(s.toString());
    }

    public static void main(String[] args) {
        fatoracao(3960);
        // System.out.println("opa");
    }
}
