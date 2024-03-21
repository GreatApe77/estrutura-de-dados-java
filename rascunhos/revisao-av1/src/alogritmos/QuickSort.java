package alogritmos;

public class QuickSort {
    public static void quicksort(int[] vetor){
        int esquerda = 0;
        int direita = vetor.length -1;
        _quicksort(vetor, esquerda, direita);
    }
    private static void _quicksort(int[] vetor,int esquerda, int direita){
        if(direita<=esquerda) return;
        int posicaoPivot = _partition(vetor, esquerda, direita);
        _quicksort(vetor, posicaoPivot+1, direita);
        _quicksort(vetor, esquerda, posicaoPivot-1);
    }
    private static int _partition(int[] vetor,int esquerda,int direita){
        int elementoPivot = vetor[direita];
        int i = esquerda-1;
        int j = esquerda;
        //for (int j = esquerda; j <= direita-1; j++) {
         //   if(vetor[j]<elementoPivot){
        ////        i++;
        //        int aux = vetor[j];
        //        vetor[j] = vetor[i];
        //        vetor[i] = aux;
        //    }
       // }
        i = testeRecursivo(vetor, j, i, direita, elementoPivot);
        i++;
        int aux = vetor[i];
        vetor[i] = vetor[direita];
        vetor[direita] = aux;
        return i;
    }
    private static int testeRecursivo(int[] vetor,int j,int i,int direita,int elementoPivot){
        if( j>direita-1){
            return i;
        }
        if(vetor[j]<elementoPivot){
            i++;
            int aux = vetor[j];
            vetor[j] = vetor[i];
            vetor[i] = aux;
        }
        return testeRecursivo(vetor, j+1, i, direita, elementoPivot);
    }
}
