import pilha.Pilha;

public class TorreDeHanoi {

    public static void torreDeHanoi(int n, Pilha<Integer> original, Pilha<Integer> aux, Pilha<Integer> dest) {
        if(n>0){
            torreDeHanoi(n-1, original, dest, aux);
            dest.empilha(original.desempilha());
            System.out.println("Original" + original);
            System.out.println("Destino"+ dest);
            System.out.println("Aux"+aux);
            torreDeHanoi(n-1, aux, original, dest);
        }
    }

    public static void main(String[] args) {
        Pilha<Integer> original = new Pilha<Integer>();
        Pilha<Integer> aux = new Pilha<Integer>();
        Pilha<Integer> destino = new Pilha<Integer>();
        original.empilha(3);
        original.empilha(2);
        original.empilha(1);
        torreDeHanoi(original.tamanho(), original, aux, destino);
    }
}
