import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 * IMPORTANT:
 * O nome da classe deve ser "Main" para que a sua solução execute
 * Class name must be "Main" for your solution to execute
 * El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Main {

    public static void popularVetorDivindoPor2(Double[] vetor, int posicao) {

        if (posicao == 99) {
            vetor[99] = vetor[98] / 2;
            return;
        }
        vetor[posicao] = vetor[posicao - 1] / 2;
        popularVetorDivindoPor2(vetor, posicao + 1);
    }

    public static void printarFormatado(int posicao, Double valor) {
        String valorFormatadoComPonto = String.format(Locale.US,"%.4f",valor);
        System.out.println("N[" + posicao + "] = "+valorFormatadoComPonto);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Double entradaX = scanner.nextDouble();
        Double[] vetorN = new Double[100];
        vetorN[0] = entradaX;
        popularVetorDivindoPor2(vetorN, 1);
        for (int i = 0; i < vetorN.length; i++) {
            printarFormatado(i, vetorN[i]);
        }
        scanner.close();
    }

}