package alogritmos;

public class SomarVetor {
    public static int somatorioVetor(int[] vetor){
        return _somatorioVetor(vetor, 0);
    }
    private static int _somatorioVetor(int[] vetor,int n){
        if(n==vetor.length){
            return 0;
        }
        return vetor[n]+ _somatorioVetor(vetor, n+1);

    }
}
