import filaEstaticaCircular.FilaEstatica;

public class App {
    public static void main(String[] args) throws Exception {
        FilaEstatica<String> fila = new FilaEstatica<String>(3);
        fila.enfileira("Mateus");
        fila.enfileira("Joao");
        fila.enfileira("Daniel");
        System.out.println(fila);
        
        /*
         * fila.desenfileira();
         * fila.desenfileira();
         * fila.desenfileira();
         * fila.enfileira("Marselo");
         * fila.enfileira("Manoel Carlos");
         * fila.desenfileira();
         * System.out.println(fila.frente());
         */
    }
}
