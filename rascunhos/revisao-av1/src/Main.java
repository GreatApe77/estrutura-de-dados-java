import java.util.Arrays;

import alogritmos.InverterVetor;
import alogritmos.Mdc;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] vetor = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        InverterVetor.inverterVtor(vetor);
        System.out.println(Arrays.toString(vetor));
        System.out.println(Mdc.mdc(12, 4));
    }
}
