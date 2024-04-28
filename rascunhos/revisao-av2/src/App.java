import fila.FilaEstaticaCircular;
import pilha.PilhaDinamica;
import pilha.PilhaEstatica;

public class App {
    public static void main(String[] args) throws Exception {
        PilhaDinamica<String> pilhaDeLivros = new PilhaDinamica<String>();
        pilhaDeLivros.empilha("Senhor dos Aneis");
        // pilhaDeLivros.empilha("AOT");
        // pilhaDeLivros.empilha("Apostila");
        System.out.println(pilhaDeLivros);
        String desempilhado = pilhaDeLivros.desempilha();
        System.out.println(desempilhado);
        System.out.println(pilhaDeLivros.topo());
        System.out.println(pilhaDeLivros);
        pilhaDeLivros.empilha(desempilhado);
        System.out.println(pilhaDeLivros);
        pilhaDeLivros.empilha("Bom dia");
        System.out.println(pilhaDeLivros);
    }
}
