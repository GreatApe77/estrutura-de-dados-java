import vetor.ILista;
import vetor.Lista;

public class App {
    public static void main(String[] args) throws Exception {
        ILista<String> lista = new Lista<String>(new String[] { "Chiu", "Au", "A" });
        System.out.println(lista.toString());
        lista.atualizarElementoEmPosicao(1, "TESTTTTTTTTTTTTTT");
        System.out.println(lista.toString());

        
    }
}
