import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import filaEstaticaCircular.FilaEstatica;

public class App {
    public static void main(String[] args) throws Exception {
        // FilaEstatica<String> fila = new FilaEstatica<String>(3);
        // fila.enfileira("Mateus");
        // fila.enfileira("Joao");
        // fila.enfileira("Daniel");
        // System.out.println(fila);

        // int[] vetorTeste = new int[] { 4, 5, 6, 3, 23, 6, 7, 3, 2, 4, 6, 5, 2, 1, 2,
        // 3, 56, 7, 5, 3, 5, 6, 3, 45, 6 };
        int[] vetorTeste = new int[1000000000];
        long startTime = System.nanoTime();

        popularVetor(vetorTeste);
        long stopTime = System.nanoTime();
        // System.out.println(stopTime - startTime);
        startTime = System.nanoTime();
        // bubbleSort(vetorTeste);
        //quicksort(vetorTeste);
        Arrays.sort(vetorTeste);
        stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);

        // System.out.println(Arrays.toString(vetorTeste));
        /*
         * fila.desenfileira();
         * fila.desenfileira();
         * fila.desenfileira();
         * fila.enfileira("Marselo");
         * fila.enfileira("Manoel Carlos");
         * fila.desenfileira();
         * System.out.println(fila.frente());
         */
    }

    public static void quicksort(int[] vetor) {
        int start = 0;
        int end = vetor.length - 1;
        _quicksort(vetor, start, end);
    }

    private static void _quicksort(int[] vetor, int start, int end) {
        if (end <= start) {
            return;
        }
        int pivot = _partition(vetor, start, end);
        _quicksort(vetor, start, pivot - 1);
        _quicksort(vetor, pivot + 1, end);
    }

    private static int _partition(int[] vetor, int start, int end) {
        int pivot = vetor[end];
        int i = start - 1;
        for (int j = start; j <= end - 1; j++) {
            if (pivot > vetor[j]) {
                i++;
                int aux = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = aux;
            }
        }
        i++;
        int aux = vetor[end];
        vetor[end] = vetor[i];
        vetor[i] = aux;
        return i;
    }

    public static void bubbleSort(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }
    }

    public static void popularVetor(int[] vetor) {
        Random random = new Random();
        for (int i = 0; i < vetor.length; i++) {

            vetor[i] = random.nextInt(100);
        }
    }
}
