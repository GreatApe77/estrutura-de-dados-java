
import entities.ListaDuplamenteEncadeada;

public class Main {
    public static void main(String[] args) throws Exception {
        ListaDuplamenteEncadeada<Integer> listaDuplamenteEncadeada = new ListaDuplamenteEncadeada<Integer>();
        listaDuplamenteEncadeada.inserirComeco(77);
        listaDuplamenteEncadeada.inserirComeco(88);
        listaDuplamenteEncadeada.inserirFinal(1000);
        listaDuplamenteEncadeada.insereOrdenado(10001);
        listaDuplamenteEncadeada.insereOrdenado(90);
        listaDuplamenteEncadeada.insereOrdenado(1);
        
        listaDuplamenteEncadeada.imprimeEmOrdem();
        listaDuplamenteEncadeada.imprimeInvertido();
    }
}
