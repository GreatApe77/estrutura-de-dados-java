import pilha.PilhaEstatica;

public class App {
    public static void main(String[] args) throws Exception {
        PilhaEstatica<String> pilhaDeLivros = new PilhaEstatica<String>(20);
        pilhaDeLivros.empilha("Senhor dos Aneis");
        pilhaDeLivros.empilha("AOT");
        pilhaDeLivros.empilha("Apostila");
        System.out.println(pilhaDeLivros);
        String desempilhado = pilhaDeLivros.desempliha();
        System.out.println(desempilhado);
        System.out.println(pilhaDeLivros.topo());
        System.out.println(pilhaDeLivros);
    }
}
