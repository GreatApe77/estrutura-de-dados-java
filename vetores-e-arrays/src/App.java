import vetor.Vetor;

public class App {
    public static void main(String[] args) throws Exception {
        Vetor vetor = new Vetor(5);
        vetor.adicionarElementoNoFinal(7);
        vetor.adicionarElementoNoFinal(55);
        System.out.println(vetor.toString());
    }
}
