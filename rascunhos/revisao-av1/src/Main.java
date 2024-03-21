import java.util.Arrays;

import alogritmos.DivisaoInteira;
import alogritmos.InverterVetor;
import alogritmos.Mdc;
import alogritmos.QuickSort;
import alogritmos.SomarVetor;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] vetor = new int[] { 1, 2, 3, 4,9999,77,4,2,4,56,5,32,7,3,1,6,8,3,4,7,23,4,6,3,22, 5, 6, 7, 8, 9 };
        InverterVetor.inverterVtor(vetor);
        System.out.println(Arrays.toString(vetor));
        System.out.println(Mdc.mdc(12, 4));
        System.out.println(DivisaoInteira.divisaoInteira(8, 4));
        System.out.println(SomarVetor.somatorioVetor(vetor));
        QuickSort.quicksort(vetor);
        System.out.println(Arrays.toString(vetor));

    }
}
