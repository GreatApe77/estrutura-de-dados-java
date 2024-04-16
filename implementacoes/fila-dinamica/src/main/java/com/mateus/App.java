package com.mateus;

import com.mateus.filaDinamica.FilaDinamica;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        FilaDinamica<String> filaDinamica = new FilaDinamica<String>();
        filaDinamica.enfileira("Mateus");
        filaDinamica.enfileira("Manoel Carlos");
        filaDinamica.enfileira("Kiko");
        filaDinamica.desenfileira();
        filaDinamica.desenfileira();
        System.out.println(filaDinamica);
        System.out.println(filaDinamica.frente());
    }
}
