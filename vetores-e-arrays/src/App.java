import vetor.Vetor;

public class App {
    public static void main(String[] args) throws Exception {
        Vetor vetor = new Vetor(10);
        vetor.adicionarElementoNoFinal(7);
        vetor.adicionarElementoNoFinal(55);
        vetor.adicionarElementoNoFinal(88);
        vetor.adicionarElementoNoFinal(6);
        vetor.adiciona(1, 200);
        vetor.adicionarElementoNoFinal(700);
        vetor.adiciona(0, 9999);
        System.out.println(vetor.toString());
        System.out.println(vetor.indiceDoElemento(6));
    }
}
