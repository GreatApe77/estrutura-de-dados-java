import fila.Fila;

public class App {
    public static void main(String[] args) throws Exception {

        Fila<Integer> fila = new Fila<Integer>(10);
        fila.enfileira(1);
        fila.enfileira(2);
        fila.enfileira(3);
        fila.enfileira(4);
        fila.enfileira(5);
        fila.desenfileira();
        System.out.println(fila);
        System.out.println(fila.espiar());

    }
}
