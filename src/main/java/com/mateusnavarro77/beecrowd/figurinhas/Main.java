import java.io.IOException;

import java.util.Scanner;

/**
 * IMPORTANT:
 * O nome da classe deve ser "Main" para que a sua solução execute
 * Class name must be "Main" for your solution to execute
 * El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Main {
    public static int calcularMDC(int a, int b) {
        
        if (b == 0)
            return a;
        int resto = a % b;
        a = b;
        b = resto;
        return calcularMDC(a, b);

    }
    /* private static void _entradaDeDados(int i,int entradaN,Scanner scanner){
        if( i==entradaN){
            return;
        }


        String entradaNumeros = scanner.next();
        String[] entradaSeparadaPorEspacos =entradaNumeros.split(" ");
        //System.out.println(Arrays.toString(entradaSeparadaPorEspacos));
        String f1 = entradaSeparadaPorEspacos[0];
        String f2 = entradaSeparadaPorEspacos[1];
        int mdc = calcularMDC(Integer.parseInt(f1), Integer.parseInt(f2));
        System.out.println(mdc);
        _entradaDeDados(i+1, entradaN, scanner);
    } */
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\\n");
        int entradaN = scanner.nextInt();
        //int i=0;
       //_entradaDeDados(i, entradaN, scanner);
       for (int i = 0; i < entradaN; i++) {
        String entradaNumeros = scanner.next();
        String[] entradaSeparadaPorEspacos =entradaNumeros.split(" ");
        //System.out.println(Arrays.toString(entradaSeparadaPorEspacos));
        String f1 = entradaSeparadaPorEspacos[0];
        String f2 = entradaSeparadaPorEspacos[1];
        int mdc = calcularMDC(Integer.parseInt(f1), Integer.parseInt(f2));
        System.out.println(mdc);
       }
        scanner.close();
        /**
         * Escreva a sua solução aqui
         * Code your solution here
         * Escriba su solución aquí
         */
        /*
         * String palavra = "Oi Bom Dia";
         * String[] array = palavra.split(" ");
         * for (int i = 0; i < array.length; i++) {
         * System.out.println(array[i]);
         * }
         */
    }

}