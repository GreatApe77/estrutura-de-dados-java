import filaComPrioridade.FilaComPrioridade;

public class App {
    public static void main(String[] args) throws Exception {

        FilaComPrioridade<Integer> fila = new FilaComPrioridade<Integer>(20);
        Integer a = 6;
        fila.enfileira(a);
        fila.enfileira(5);
        fila.enfileira(875);
        fila.enfileira(8);
        fila.enfileira(875);
        fila.enfileira(855);
        fila.enfileira(5);
        fila.enfileira(375);
        fila.enfileira(1);
        fila.enfileira(10);
        System.out.println(fila);

        /* Fila<Integer> fila = new Fila<Integer>(10);
        fila.enfileira(1);
        fila.enfileira(2);
        fila.enfileira(3);
        fila.enfileira(4);
        fila.enfileira(5); */

        /* fila.desenfileira();
        System.out.println(fila);
        System.out.println(fila.espiar());
        fila.desenfileira();
        System.out.println(fila.espiar());
        System.out.println(fila); */

    }
}
