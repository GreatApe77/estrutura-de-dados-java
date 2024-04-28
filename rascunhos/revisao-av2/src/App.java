import fila.FilaDinamica;
import fila.FilaEstaticaCircular;
import filaDePrioridade.FilaPrioridadeHeap;
import pilha.PilhaDinamica;
import pilha.PilhaEstatica;

public class App {
    public static void main(String[] args) throws Exception {
        FilaPrioridadeHeap fila = new FilaPrioridadeHeap(20);
        fila.enfileira(50);
        fila.enfileira(20);
        fila.enfileira(999);
        fila.enfileira(1000);
        fila.enfileira(8000);
        fila.enfileira(1000);
        fila.enfileira(2);
        System.out.println(fila.desenfileira());//8000
        System.out.println(fila.desenfileira());//1000
        System.out.println(fila.desenfileira());//1000
        System.out.println(fila.desenfileira());//999
        System.out.println(fila.desenfileira());//50
        System.out.println(fila.desenfileira());//20
        System.out.println(fila.desenfileira());//2

    }
}
