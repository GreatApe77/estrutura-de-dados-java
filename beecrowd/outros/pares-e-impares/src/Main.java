import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

class QuickSort {
    private static int _partition(int[] array, int inicio, int fim) {
        int pivot = array[fim];
        int i = inicio;
        for (int j = inicio; j < fim; j++) {
            if (array[j] <= pivot) {
                int auxiliar = array[j];
                array[j] = array[i];
                array[i] = auxiliar;
                i++;
            }
        }
        int auxiliar = array[i];
        array[i] = array[fim];
        array[fim] = auxiliar;
        return i;
    }

    private static void _quickSort(int[] array, int inicio, int fim) {
        if (fim == -1) {
            fim = array.length - 1;
        }
        if (inicio < fim) {
            int posicaoPivot = _partition(array, inicio, fim);
            _quickSort(array, inicio, posicaoPivot - 1);
            _quickSort(array, posicaoPivot + 1, fim);
        }
    }

    public static void quickSort(int[] array) {
        int inicio = 0;
        int fim = -1;
        _quickSort(array, inicio, fim);

    }

    private static void _quickSortDecrescente(int[] array, int inicio, int fim) {
        if (fim == -1) {
            fim = array.length - 1;
        }
        if (inicio < fim) {
            int posicaoPivot = _partitionDecrescente(array, inicio, fim);
            _quickSortDecrescente(array, inicio, posicaoPivot - 1);
            _quickSortDecrescente(array, posicaoPivot + 1, fim);
        }
    }

    private static int _partitionDecrescente(int[] array, int inicio, int fim) {
        int pivot = array[fim];
        int i = inicio;
        for (int j = inicio; j < fim; j++) {
            if (array[j] >= pivot) {
                int auxiliar = array[j];
                array[j] = array[i];
                array[i] = auxiliar;
                i++;
            }
        }
        int auxiliar = array[i];
        array[i] = array[fim];
        array[fim] = auxiliar;
        return i;
    }

    public static void quickSortDecrescente(int[] array) {
        int inicio = 0;
        int fim = -1;
        _quickSortDecrescente(array, inicio, fim);
    }
}

public class Main {
    /*
     * public static void ordenaListaCrescente(Lista<Integer> lista){
     * for (int i = 0; i < lista.tamanho(); i++) {
     * for (int j = 0; j < lista.tamanho()-1; j++) {
     * if(lista.pesquisarPorIndice(j)>lista.pesquisarPorIndice(j+1)){
     * int auxiliar = lista.pesquisarPorIndice(j+1);
     * lista.setElemento(j+1, lista.pesquisarPorIndice(j));
     * lista.setElemento(j,auxiliar);
     * }
     * }
     * }
     * }
     * public static void ordenaListaDecrescente(Lista<Integer> lista){
     * for (int i = 0; i < lista.tamanho(); i++) {
     * for (int j = 0; j < lista.tamanho()-1; j++) {
     * if(lista.pesquisarPorIndice(j)<lista.pesquisarPorIndice(j+1)){
     * int auxiliar = lista.pesquisarPorIndice(j+1);
     * lista.setElemento(j+1, lista.pesquisarPorIndice(j));
     * lista.setElemento(j,auxiliar);
     * }
     * }
     * }
     * }
     */
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        // Lista<Integer> pares = new Lista<Integer>(100000);
        // Lista<Integer> impares = new Lista<Integer>(100000);
        int[] pares = new int[100000];
        int[] impares = new int[100000];
        int tamanhoPares = 0;
        int tamanhoImpares = 0;
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int numeroEntrada = scanner.nextInt();

            if (numeroEntrada % 2 == 0) {
                // par
                pares[tamanhoPares] = numeroEntrada;
                tamanhoPares++;
            } else {
                impares[tamanhoImpares] = numeroEntrada;
                tamanhoImpares++;
            }
        }
        QuickSort.quickSort(pares);
        QuickSort.quickSortDecrescente(impares);
        // ordenaListaDecrescente(impares);
        for (int i = 0; i < tamanhoPares; i++) {
            System.out.println(pares[i]);
        }

        for (int i = 0; i < tamanhoImpares; i++) {
            System.out.println(impares[i]);
        }
        scanner.close();

        // int[] l = new int[] { 123, 42, 2, 1, 4, 6, 734, 3, 3, 3, 5, 7, 444, 3, 222,
        // 4, 6, 7, 6, 45, 3, 2, 1, 1, 5 };
        // QuickSort.quickSort(l);
        // System.out.println(Arrays.toString(l));
        // QuickSort.quickSort(l);
        // System.out.println(Arrays.toString(l));
        // QuickSort.quickSortDecrescente(l);
        // System.out.println(Arrays.toString(l));

    }
}
