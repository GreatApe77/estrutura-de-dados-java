package com.mateus.oitodamas;

import java.util.HashMap;
import java.util.Map;

public class OitoDamas {
    static int DAMA = 1;
    static int SEM_DAMA = 0;

    public static void main(String[] args) {
        int n = 8;

        oitoDamas(n);
    }

    public static void oitoDamas(int n) {

        Map<Integer, Boolean> mapaLinhas = new HashMap<Integer, Boolean>(n);
        Map<Integer, Boolean> mapaColunas = new HashMap<Integer, Boolean>(n);
        Map<Integer, Boolean> mapaDPS = new HashMap<Integer, Boolean>(n);
        Map<Integer, Boolean> mapaDSI = new HashMap<Integer, Boolean>(n);
        int[][] tabuleiro = new int[n][n];

        _oitoDamas(tabuleiro, 0, mapaLinhas, mapaColunas, mapaDPS, mapaDSI);
    }

    /**
     * 0 1 2 3 4 5 6 7
     * _________________
     * 0 | | | | | | | |d|
     * 1 | | | | | | |d| |
     * 2 | |x| | | |d| | |
     * 3 | | | | |d| | | |
     * 4 | | | |d| | | | |
     * 5 | | |d| | | | | |
     * 6 | |d| | | | | | |
     * 7 |d| | | | | | | |
     * 
     */
    public static boolean _oitoDamas(
            int[][] tabuleiro,
            int coluna,
            Map<Integer, Boolean> mapaLinhas,
            Map<Integer, Boolean> mapaColunas,
            Map<Integer, Boolean> mapaDPS,
            Map<Integer, Boolean> mapaDSI) {
        if (tabuleiro.length == coluna) {
            _printarTabuleiro(tabuleiro);
            return true;
        }

        for (int i = 0; i < tabuleiro.length; i++) {
            int diagonalPrincipal = i - coluna + tabuleiro.length - 1;
            int diagonalSecundaria = i + coluna;
            if (_ehSeguro(
                    coluna,
                    i,
                    diagonalPrincipal,
                    diagonalSecundaria,
                    mapaLinhas,
                    mapaColunas,
                    mapaDPS,
                    mapaDSI)) {

                tabuleiro[i][coluna] = DAMA;
                mapaColunas.put(coluna, true);
                mapaLinhas.put(i, true);
                mapaDPS.put(diagonalPrincipal, true);
                mapaDSI.put(diagonalSecundaria, true);
                if (_oitoDamas(
                        tabuleiro,
                        coluna + 1,
                        mapaLinhas,
                        mapaColunas,
                        mapaDPS,
                        mapaDSI)) {
                    return true;
                }
                System.out.println("BACKTRACKING EXECUTADO !");
                tabuleiro[i][coluna] = SEM_DAMA;
                mapaColunas.put(coluna, false);
                mapaLinhas.put(i, false);
                mapaDPS.put(diagonalPrincipal, false);
                mapaDSI.put(diagonalSecundaria, false);
            }
        }
        return false;
    }

    private static boolean _ehSeguro(
            int coluna,
            int linha,
            int diagonalPrincipal,
            int diagonalSecundaria,
            Map<Integer, Boolean> mapaLinhas,
            Map<Integer, Boolean> mapaColunas,
            Map<Integer, Boolean> mapaDPS,
            Map<Integer, Boolean> mapaDSI) {

        Boolean linhaOcupada = mapaLinhas.get(linha);
        if (linhaOcupada == null) {
            linhaOcupada = false;
        }
        Boolean colunaOcupada = mapaColunas.get(coluna);
        if (colunaOcupada == null) {
            colunaOcupada = false;
        }
        Boolean diagonalPrincipalOcupada = mapaDPS.get(diagonalPrincipal);
        if (diagonalPrincipalOcupada == null) {
            diagonalPrincipalOcupada = false;
        }
        Boolean diagonalSecundariaOcupada = mapaDSI.get(diagonalSecundaria);
        if (diagonalSecundariaOcupada == null) {
            diagonalSecundariaOcupada = false;
        }
        return !linhaOcupada && !colunaOcupada && !diagonalPrincipalOcupada && !diagonalSecundariaOcupada;
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
