import java.util.Arrays;

import alogritmos.DivisaoInteira;
import alogritmos.InverterVetor;
import alogritmos.Mdc;
import alogritmos.SomarVetor;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] vetor = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        InverterVetor.inverterVtor(vetor);
        System.out.println(Arrays.toString(vetor));
        System.out.println(Mdc.mdc(12, 4));
        System.out.println(DivisaoInteira.divisaoInteira(8, 4));
        System.out.println(SomarVetor.somatorioVetor(vetor));
    }
}
