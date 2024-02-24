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
        int variedadeColetados = getVariedadeDePomekonsColetados();
        int variedadePokemons = getTotalDePomekonsDisponiveis();
        if (variedadeColetados >= variedadePokemons)
            return 0;
        // return getTotalDePomekonsDisponiveis() - getVariedadeDePomekonsColetados();
        return variedadePokemons - variedadeColetados;
    }

}

public class Main {
    public static void printarFormatado(int quantidadePomekons) {
        System.out.println("Falta(m) " + quantidadePomekons + " pomekon(s).");
    }

    public static void entradaBeecrowd() {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] pokemonsCapturados = new String[N];
        entrarDadosRecursivos(0, scanner, pokemonsCapturados);

        ColecaoPomekon colecao = new ColecaoPomekon(pokemonsCapturados);
        int pokemonsRestantes = colecao.getTotalNaoCapturados();
        printarFormatado(pokemonsRestantes);
        scanner.close();
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
        //entradaBeecrowd();

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

        // Scanner scanner = new Scanner(System.in);
        // int N = scanner.nextInt();
        // String[] pokemonsCapturados = new String[N];
        // for (int i = 0; i < pokemonsCapturados.length; i++) {
        /*
         * String pokemon = scanner.next();
         * pokemonsCapturados[i] = pokemon;
         */
        // pokemonsCapturados[i] = "a";
        // }
        // ColecaoPomekon colecaoPomekon = new ColecaoPomekon(pokemonsCapturados);
        // System.out.println(Arrays.toString(colecaoPomekon.getMochilaSemRepetidos()));
        // System.out.println(colecaoPomekon.getTotalNaoCapturados());

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
        /*
         * String[] pokemonsCapturados = new String[146];
         * 
         * for (int i = 0; i < pokemonsCapturados.length; i++) {
         * pokemonsCapturados[i] = String.format("%d", i);
         * }
         * ColecaoPomekon colecao = new ColecaoPomekon(pokemonsCapturados);
         * int pokemonsRestantes = colecao.getTotalNaoCapturados();
         * printarFormatado(pokemonsRestantes);
         */
/*         String[] pokemonsPrimeiraGeracao = {
                "Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard",
                "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree",
                "Weedle", "Kakuna", "Beedrill", "Pidgey", "Pidgeotto", "Pidgeot",
                "Rattata", "Raticate", "Spearow", "Fearow", "Ekans", "Arbok",
                "Pikachu", "Raichu", "Sandshrew", "Sandslash", "Nidoran♀", "Nidorina",
                "Nidoqueen", "Nidoran♂", "Nidorino", "Nidoking", "Clefairy", "Clefable",
                "Vulpix", "Ninetales", "Jigglypuff", "Wigglytuff", "Zubat", "Golbat",
                "Oddish", "Gloom", "Vileplume", "Paras", "Parasect", "Venonat",
                "Venomoth", "Diglett", "Dugtrio", "Meowth", "Persian", "Psyduck",
                "Golduck", "Mankey", "Primeape", "Growlithe", "Arcanine", "Poliwag",
                "Poliwhirl", "Poliwrath", "Abra", "Kadabra", "Alakazam","Alakazam", "Machop",
                "Machoke", "Machamp", "Bellsprout", "Weepinbell", "Victreebel", "Tentacool",
                "Tentacruel", "Geodude", "Graveler", "Golem", "Ponyta", "Rapidash",
                "Slowpoke", "Slowbro", "Magnemite", "Magneton", "Farfetch'd", "Doduo",
                "Dodrio", "Seel", "Dewgong", "Grimer", "Muk", "Shellder",
                "Cloyster", "Gastly", "Haunter", "Gengar", "Onix", "Drowzee",
                "Hypno", "Krabby", "Kingler", "Voltorb", "Electrode", "Exeggcute",
                "Exeggutor", "Cubone", "Marowak", "Hitmonlee", "Hitmonchan", "Lickitung",
                "Koffing", "Weezing", "Rhyhorn", "Rhydon", "Chansey", "Tangela",
                "Kangaskhan", "Horsea", "Seadra", "Goldeen", "Seaking", "Staryu",
                "Starmie", "Mr. Mime", "Scyther", "Jynx", "Electabuzz", "Magmar",
                "Pinsir", "Tauros", "Magikarp", "Gyarados", "Lapras", "Ditto",
                "Eevee", "Vaporeon", "Jolteon", "Flareon", "Porygon", "Omanyte",
                "Omastar", "Kabuto", "Kabutops", "Aerodactyl", "Snorlax", "Articuno",
                "Zapdos", "Moltres", "Dratini", "Dragonair", "Dragonite", "Mewtwo",
                "Mew"
        };
        ColecaoPomekon colecao = new ColecaoPomekon(pokemonsPrimeiraGeracao);
         int pokemonsRestantes = colecao.getTotalNaoCapturados();
         printarFormatado(pokemonsRestantes); */
    }

}