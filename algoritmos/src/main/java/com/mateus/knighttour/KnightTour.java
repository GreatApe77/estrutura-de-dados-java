package com.mateus.knighttour;

public class KnightTour {

    static int n = 8;
    static int[] dx = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };
    static int[][] tabuleiro;

    public static void main(String[] args) {
        knightTour();
    }

    public static void knightTour() {

        tabuleiro = new int[n][n];
        int linhaInicial= 0;
        int colunaInicial = 0;
        tabuleiro[linhaInicial][colunaInicial] = 1;
        _knightTour(linhaInicial,colunaInicial, 1);
    }

    public static boolean _knightTour(int linha, int coluna, int totalMovimentos) {
        if (totalMovimentos == n * n) {
            printarTabuleiro();
            return true;
        }
        for (int i = 0; i < 8; i++) {
            int linhaTentada = linha + dx[i];
            int colunaTentada = coluna + dy[i];
            if (ehValido(linhaTentada, colunaTentada, tabuleiro)) {
                tabuleiro[linhaTentada][colunaTentada] = totalMovimentos + 1;
                if (_knightTour(linhaTentada, colunaTentada, totalMovimentos + 1)) {
                    return true;
                }
                tabuleiro[linhaTentada][colunaTentada] = 0;
            }

        }
        return false;
    }

    public static boolean ehValido(int linha, int coluna, int[][] tabuleiro) {
        return linha >= 0 && coluna >= 0 && linha < tabuleiro.length && coluna < tabuleiro.length
                && tabuleiro[linha][coluna] == 0;
    }

    public static void printarTabuleiro() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%2d ", tabuleiro[i][j]);
            }
            System.out.println();
        }
    }
}
