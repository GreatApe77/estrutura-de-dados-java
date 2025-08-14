package com.mateusnavarro77.algoritmos.modamatrtiz;

import java.util.ArrayList;
import java.util.HashMap;

public class ModaMatriz {
    public static int modaMatriz(int[][] matriz) {
        HashMap<Integer, Integer> inteiroParaFrequencia = new HashMap<Integer, Integer>();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (!inteiroParaFrequencia.containsKey(matriz[i][j])) {
                    inteiroParaFrequencia.put(matriz[i][j], 0);
                }
                inteiroParaFrequencia.put(matriz[i][j], inteiroParaFrequencia.get(matriz[i][j]) + 1);
            }
        }

        ArrayList<Integer> chaves = new ArrayList<Integer>(inteiroParaFrequencia.keySet());
        Integer maiorFrequencia = 0;
        Integer moda = chaves.get(0);
        for (int i = 0; i < chaves.size(); i++) {
            if (inteiroParaFrequencia.get(chaves.get(i)) > maiorFrequencia) {
                maiorFrequencia = inteiroParaFrequencia.get(chaves.get(i));
                moda = chaves.get(i);
            }
        }
        return moda;
    }
}
