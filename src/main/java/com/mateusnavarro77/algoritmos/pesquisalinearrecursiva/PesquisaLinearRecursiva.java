package com.mateusnavarro77.algoritmos.pesquisalinearrecursiva;

public class PesquisaLinearRecursiva {
    /**
     * Busca linear recursiva
     * @param lista 
     * @param elementoBuscado
     * @return o índice do elemento buscado se estiver na lista. -1 se elemento buscado não estiver na lista. 
     */
    public static int pesquisaLinearRecursiva(int[] lista, int elementoBuscado){
        int indiceAtual=0;
        int resultado = _pesquisaLinearRecursiva(lista, elementoBuscado, indiceAtual);
        return resultado;
    }
    private static int _pesquisaLinearRecursiva(int[] lista, int elementoBuscado,int indiceAtual){
        if(indiceAtual==lista.length){
            return -1;
        }
        if(lista[indiceAtual]==elementoBuscado){
            return indiceAtual;
        }
        indiceAtual++;
        return _pesquisaLinearRecursiva(lista, elementoBuscado,indiceAtual );
    }
}
