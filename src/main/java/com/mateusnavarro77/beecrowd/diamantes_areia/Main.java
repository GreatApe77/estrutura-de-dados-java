import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int contarDiamantes(String expressao) {
        PilhaEstatica<Character> pilha = new PilhaEstatica<Character>(expressao.length());
        int contadorDiamantes = 0;
        char abre = '<';
        char fecha = '>';
        for (int i = 0; i < expressao.length(); i++) {
            Character caractere = expressao.charAt(i);
            if (caractere == abre) {
                pilha.empilha(abre);
            } else if (caractere == fecha) {
                if (!pilha.estaVazia() && pilha.topo() == abre) {
                    pilha.desempilha();
                    contadorDiamantes++;
                }
            }
        }
        return contadorDiamantes;
    }

    public static void main(String[] args) throws IOException {
        //System.out.println(contarDiamantes("><><><><><>>>>>>>><>"));
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            String casoDeTeste = scanner.next();
            System.out.println(contarDiamantes(casoDeTeste));
        }
        scanner.close();
    }
}

class PilhaEstatica<T> {
    private T[] elementos;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public PilhaEstatica(int capacidade) {
        elementos = (T[]) new Object[capacidade];
        tamanho = 0;
    }

    public PilhaEstatica() {
        this(16);
    }

    public void empilha(T elemento) {
        if (estaCheia())
            throw new StackOverflowError();
        elementos[tamanho()] = elemento;
        tamanho++;
    }

    public T topo() {
        if (estaVazia())
            throw new Error("Fila esta vazia");
        return elementos[tamanho - 1];
    }

    public T desempilha() {
        T frente = topo();
        tamanho--;
        return frente;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaCheia() {
        return tamanho() == elementos.length;
    }

    public boolean estaVazia() {
        return tamanho() == 0;
    }

    @Override
    public String toString() {
        int cap = 2 + tamanho() + (2 * (tamanho() - 1)); // 2 parenteses + tamanho da pilha + ", " para cada elemento
                                                         // menos o ultimo
        StringBuilder s = new StringBuilder(cap);
        s.append("[");
        for (int i = 0; i < tamanho(); i++) {
            if (i == tamanho() - 1) {
                s.append(elementos[i]);
            } else {
                s.append(elementos[i]);
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }

}