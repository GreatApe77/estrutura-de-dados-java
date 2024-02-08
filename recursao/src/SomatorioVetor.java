public class SomatorioVetor {
    public static int somatorioDoVetor(int[] vetor,int tamanho ){
        
        if(tamanho==0)return 0;

        return vetor[tamanho-1] + somatorioDoVetor(vetor, tamanho-1);
    }
}
