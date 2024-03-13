import pilha.Pilha;

public class App {
    public static void main(String[] args) throws Exception {
        Pilha<Integer> pilha = new Pilha<Integer>(3);
        pilha.empilha(6);
        pilha.empilha(7);
        pilha.empilha(8);
        System.out.println(pilha.desempilha());
        System.out.println(pilha.desempilha());
        System.out.println(pilha.desempilha());
        

        System.out.println(pilha);
        System.out.println(pilha.estaVazia());

    }
}
