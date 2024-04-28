import fila.FilaDinamica;
import fila.FilaEstaticaCircular;
import pilha.PilhaDinamica;
import pilha.PilhaEstatica;

public class App {
    public static void main(String[] args) throws Exception {
        FilaDinamica<String> fila = new FilaDinamica<String>();
        fila.enfileira("Mateus");
        fila.enfileira("Davi");
        String saiuDaFila = fila.desenfileira();
        String saiuDaFila2 = fila.desenfileira();
        System.out.println("SAIU: "+saiuDaFila);
        System.out.println("SAIU: "+saiuDaFila2);
        System.out.println(fila.frente());
        fila.enfileira("Mateus");
        fila.enfileira("Davi");
         saiuDaFila = fila.desenfileira();
         saiuDaFila2 = fila.desenfileira();
        System.out.println("SAIU: "+saiuDaFila);
        System.out.println("SAIU: "+saiuDaFila2);
        System.out.println(fila.frente());
        fila.enfileira("Mateus");
        fila.enfileira("Davi");
         saiuDaFila = fila.desenfileira();
         saiuDaFila2 = fila.desenfileira();
        System.out.println("SAIU: "+saiuDaFila);
        System.out.println("SAIU: "+saiuDaFila2);
        System.out.println(fila.frente());
        fila.enfileira("Mateus");
        fila.enfileira("Davi");
         saiuDaFila = fila.desenfileira();
         saiuDaFila2 = fila.desenfileira();
        System.out.println("SAIU: "+saiuDaFila);
        System.out.println("SAIU: "+saiuDaFila2);
        System.out.println(fila.frente());
        
    }
}
