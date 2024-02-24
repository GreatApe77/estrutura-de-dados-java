import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class ColecaoPomekon {
    String[] mochilaDePomekons;

    ColecaoPomekon(String[] mochila) {
        this.mochilaDePomekons = mochila;
    }

    int getTotalDePomekonsDisponiveis() {
        return 151;
    }

    int capacidadeMaximaDaMochila() {
        return 1000;
    }

    String[] getMochilaSemRepetidos() {

        String[] semRepetidos = new String[capacidadeMaximaDaMochila()];

        int j = 0;
        int i = 0;

        criarMochilaSemRepeticao(semRepetidos, i, j);
        return semRepetidos;

    }

    private void criarMochilaSemRepeticao(String[] semRepetidos, int i, int j) {

        if (i == mochilaDePomekons.length - 1) {
            semRepetidos[j] = mochilaDePomekons[mochilaDePomekons.length - 1];
            return;
        }

        if (!mochilaDePomekons[i].equals(mochilaDePomekons[i + 1])) {
            semRepetidos[j] = mochilaDePomekons[i];
            j++;
        }

        criarMochilaSemRepeticao(semRepetidos, i + 1, j);

    }

    int getVariedadeDePomekonsColetados() {
        String[] listaNaoRepetidos = getMochilaSemRepetidos();

        int variedade = 0;

        for (int i = 0; i < listaNaoRepetidos.length; i++) {
            if (listaNaoRepetidos[i] != null) {
                variedade++;
            }
        }
        return variedade;

    }

    int getTotalNaoCapturados() {
        return getTotalDePomekonsDisponiveis() - getVariedadeDePomekonsColetados();
    }

}

public class Main {
    public static void printarFormatado(int quantidadePomekons) {
        System.out.println("Falta(m) " + quantidadePomekons + " pomekon(s).");
    }

    public static void entrarDadosRecursivos(int n, Scanner scanner, String[] pokemonsCapturados) {
        if (n == pokemonsCapturados.length) {
            return;
        }

        String pokemon = scanner.next();
        pokemonsCapturados[n] = pokemon;
        entrarDadosRecursivos(n + 1, scanner, pokemonsCapturados);
    }

    public static void main(String[] args) throws IOException {
        /*
         * Scanner scanner = new Scanner(System.in);
         * int N = scanner.nextInt();
         * String[] pokemonsCapturados = new String[N];
         * entrarDadosRecursivos(0, scanner, pokemonsCapturados);
         * 
         * ColecaoPomekon colecao = new ColecaoPomekon(pokemonsCapturados);
         * int pokemonsRestantes = colecao.getTotalNaoCapturados();
         * printarFormatado(pokemonsRestantes);
         */

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] pokemonsCapturados = new String[N];
        for (int i = 0; i < pokemonsCapturados.length; i++) {
            /* String pokemon = scanner.next();
            pokemonsCapturados[i] = pokemon; */
            pokemonsCapturados[i] = "a";
        }
        ColecaoPomekon colecaoPomekon = new ColecaoPomekon(pokemonsCapturados);
        System.out.println(Arrays.toString(colecaoPomekon.getMochilaSemRepetidos()));
        System.out.println(colecaoPomekon.getTotalNaoCapturados());

        /*
         * String[] pomeoknsCapturados = new String[] { "Charmander", "Caterpie",
         * "Pidgeot", "Rattata", "Zubat", "Zubat",
         * "Zubat" };
         * ColecaoPomekon colecaoPomekon = new ColecaoPomekon(pomeoknsCapturados);
         * System.out.println(Arrays.toString(colecaoPomekon.mochilaSemRepetidos()));
         * System.out.println(colecaoPomekon.getVariedadeDePomekonsColetados());
         */
        /**
         * Escreva a sua solução aqui
         * Code your solution here
         * Escriba su solución aquí
         */

    }

}