package alogritmos;

public class InverterVetor {
    public static void inverterVtor(int[] vetor){
        int start = 0;
        int end = vetor.length-1;
        _inverterVetor(vetor, start, end);
    }
    private static void _inverterVetor(int[] vetor,int start, int end){
        if(start>=end) return;
        int aux = vetor[start];
        vetor[start] = vetor[end];
        vetor[end] = aux;
        _inverterVetor(vetor, start+1, end-1);
    }
}
