import pilha.Pilha;

public class App {
    public static void main(String[] args) throws Exception {
        Pilha<Integer> pilha = new Pilha<Integer>();
        pilha.empilha(6);
        pilha.desempilha();
        pilha.empilha(6);
        pilha.empilha(6);
        pilha.empilha(9);
        // pilha.desempilha();
        pilha.empilha(888);
        pilha.desempilha();
        System.out.println(pilha.topo());
        System.out.println(pilha);

    }
}
