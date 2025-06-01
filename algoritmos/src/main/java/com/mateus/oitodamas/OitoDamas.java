package com.mateus.oitodamas;

public class OitoDamas {
    static int DAMA = 1;
    static int SEM_DAMA = 0;

    public static void main(String[] args) {
        int n = 8;
        int[][] tabuleiro = new int[n][n];

        // tabuleiro[2][1] = 1;
        // var r = _ehSeguro(tabuleiro, 2, 1);
        // System.out.println(r);
        // _printarTabuleiro(tabuleiro);

        oitoDamas(tabuleiro, 0);
    }

    /**
     * 0 1 2 3 4 5 6 7
     * _________________
     * 0 | | | | | | | | |
     * 1 | | | | | | | | |
     * 2 | |x| | | | | | |
     * 3 | | | | | | | | |
     * 4 | | | | | | | | |
     * 5 | | | | | | | | |
     * 6 | | | | | | | | |
     * 7 | | | | | | | | |
     * 
     * 
     * 
     */
    public static boolean oitoDamas(int[][] tabuleiro, int coluna) {
        if (tabuleiro.length == coluna) {
            _printarTabuleiro(tabuleiro);
            return true;
        }

        for (int i = 0; i < tabuleiro.length; i++) {
            if (_ehSeguro(tabuleiro, coluna, i)) {

                tabuleiro[i][coluna] = DAMA;
                if (oitoDamas(tabuleiro, coluna + 1)) {
                    return true;
                }
                tabuleiro[i][coluna] = SEM_DAMA;
            }
        }
        return false;
    }

    private static boolean _ehSeguro(int[][] tabuleiro, int coluna, int linha) {
        // analisar coluna
        for (int i = linha; i >= 0; i--) {
            if (tabuleiro[i][coluna] == DAMA) {
                return false;
            }
        }
        // analisar linha
        for (int i = coluna; i >= 0; i--) {
            if (tabuleiro[linha][i] == DAMA) {
                return false;
            }
        }

        for (int i = linha - 1, j = coluna - 1; i >= 0 && j >= 0; i--, j--) {
            if (tabuleiro[i][j] == DAMA)
                return false;
        }
        for (int i = linha + 1, j = coluna - 1; i < tabuleiro.length && j >= 0; i++, j--) {
            if (tabuleiro[i][j] == DAMA)
                return false;
        }
        return true;
    }

    private static void _printarTabuleiro(int[][] tabuleiro) {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j] == DAMA ? "x " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
