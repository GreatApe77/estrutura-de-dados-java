
import entities.ListaDuplamenteEncadeada;

public class Main {
    public static void main(String[] args) throws Exception {
        ListaDuplamenteEncadeada<Integer> listaDuplamenteEncadeada = new ListaDuplamenteEncadeada<Integer>();
        listaDuplamenteEncadeada.inserirComeco(77);
        listaDuplamenteEncadeada.inserirComeco(88);
        listaDuplamenteEncadeada.imprimeEmOrdem();
        listaDuplamenteEncadeada.imprimeInvertido();
    }
}
