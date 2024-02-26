import vetor.ILista;
import vetor.Lista;

public class App {
    public static void main(String[] args) throws Exception {
        ILista<String> lista = new Lista<String>(new String[] { "A", "B", "C", "D", "E", "F", "F", "F", "F" });
        System.out.println(lista.toString());

    }
}
