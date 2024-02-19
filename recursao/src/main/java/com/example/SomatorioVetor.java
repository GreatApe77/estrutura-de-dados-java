package com.example;
public class SomatorioVetor {
    
      public static int somatorioDoVetor(int[] vetor,int tamanho ){
      
      if(tamanho==0)return 0;
      
      return vetor[tamanho-1] + somatorioDoVetor(vetor, tamanho-1);
      }
    
    /* public static int somatorioDoVetor(int[] vetor) {
        if (vetor.length == 1)
            return vetor[0];
        if(vetor.length==2){
            return vetor[0]+vetor[1];
        }
        
        int[] vetorCortado = new int[]{vetor};
        
        return vetor[vetor.length - 1] + somatorioDoVetor(vetorCortado);
    } */
}
