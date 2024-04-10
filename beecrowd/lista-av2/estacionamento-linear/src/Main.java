import java.util.Scanner;
class Carro{
    public int chegada;
    public int saida;
    public Carro(int chegada, int saida){
        this.chegada = chegada;
        this.saida = saida;
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        //String s = scanner.next();
        while (true) {

            String[] primeiraLinha = scanner.next().split(" ");
            int N = Integer.parseInt(primeiraLinha[0]);
            int K = Integer.parseInt(primeiraLinha[1]);
            if (N == K)
                break;
            PilhaEstatica<Carro> estacionamento = new PilhaEstatica<Carro>(K);
            int horarioAtual =0;
            for (int i = 0; i < N; i++) {
                String[] linhas = scanner.next().split(" ");
                Carro carro = new Carro(Integer.parseInt(linhas[0]),Integer.parseInt(linhas[1]));
                
            }
        }
        scanner.close();
    }
}

class PilhaEstatica<T> {
    private T[] elementos;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public PilhaEstatica(int capacidadeMaxima) {
        this.elementos = (T[]) new Object[capacidadeMaxima];
        this.tamanho = 0;
    }

    public PilhaEstatica() {
        this(10);
    }

    public boolean estaVazia() {
        return this.tamanho() == 0;
    }

    public boolean estaCheia() {
        return this.tamanho() == this.elementos.length;
    }

    public void empilhar(T element) {
        if (estaCheia())
            throw new StackOverflowError();

        this.elementos[tamanho()] = element;
        this.tamanho++;
    }

    public T desempilhar() {
        if (estaVazia())
            throw new Error("Empty stack");
        T topElement = topo();
        this.tamanho--;
        return topElement;
    }

    public T topo() {

        return this.elementos[tamanho() - 1];
    }

    public int tamanho() {
        return this.tamanho;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < tamanho(); i++) {
            if (i == tamanho() - 1) {
                s.append(this.elementos[i]);
            } else {
                s.append(this.elementos[i]);
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }
}