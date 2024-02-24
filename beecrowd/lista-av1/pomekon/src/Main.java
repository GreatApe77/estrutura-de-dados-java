import java.io.IOException;
import java.util.Scanner;

class ColecaoPomekon {
    String[] mochilaDePomekons;

    ColecaoPomekon(String[] mochila) {
        this.mochilaDePomekons = mochila;
    }

    int getTotalDePomekonsDisponiveis() {
        return 151;
    }

    String[] mochilaSemRepetidos() {

        String[] semRepetidos = new String[getTotalDePomekonsDisponiveis()];

        int j = 0;

        for (int i = 0; i < mochilaDePomekons.length - 1; i++) {
            if (!mochilaDePomekons[i].equals(mochilaDePomekons[i + 1])){
                semRepetidos[j] = mochilaDePomekons[i];
                j++;
            }

        }

        semRepetidos[j] = mochilaDePomekons[mochilaDePomekons.length - 1];
        return semRepetidos;

    }

    int getVariedadeDePomekonsColetados(){
        String[] listaNaoRepetidos = mochilaSemRepetidos();
        
        int variedade = 0;

        for (int i = 0; i < listaNaoRepetidos.length; i++) {
            if(listaNaoRepetidos[i]!=null){
                variedade++;
            }
        }
        return variedade;
        
    }
    
    int getTotalNaoCapturados(){
        return getTotalDePomekonsDisponiveis() - getVariedadeDePomekonsColetados();
    }

}

public class Main {
    public static void printarFormatado(int quantidadePomekons){
        System.out.println("Falta(m) "+quantidadePomekons+" pomekon(s).");
    }
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] pokemonsCapturados = new String[N];
        for (int i = 0; i < pokemonsCapturados.length; i++) {
            String pokemon = scanner.next();
            pokemonsCapturados[i] = pokemon;
        }
        ColecaoPomekon colecaoPomekon = new ColecaoPomekon(pokemonsCapturados);
        int pokemonsRestantes = colecaoPomekon.getTotalNaoCapturados();
        printarFormatado(pokemonsRestantes);
        //String[] pomeoknsCapturados = new String[] { "Charmander", "Caterpie", "Pidgeot", "Rattata", "Zubat", "Zubat",
        //        "Zubat" };
        //ColecaoPomekon colecaoPomekon = new ColecaoPomekon(pomeoknsCapturados);
        
        //System.out.println(colecaoPomekon.getVariedadeDePomekonsColetados());
        /**
         * Escreva a sua solução aqui
         * Code your solution here
         * Escriba su solución aquí
         */

    }

}