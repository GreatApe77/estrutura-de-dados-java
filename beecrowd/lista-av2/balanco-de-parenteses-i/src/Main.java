class ValidadorDeExpressao {

    public static boolean validar(String expressao) {
        PilhaEstatica<String> stack = new PilhaEstatica<String>(expressao.length());
        char abreParenteses = '(';
        char fechaParenteses = ')';
        boolean temParenteses = false;
        for (int i = 0; i < expressao.length(); i++) {
            char currentChar = expressao.charAt(i);
            if(currentChar==abreParenteses){
                stack.empilhar("(");
                temParenteses = true;
            }else if(expressao.charAt(i)==fechaParenteses){
                if(stack.estaVazia()) return false;
                stack.desempilhar();
                temParenteses = true;
            }
        }
        return temParenteses && stack.estaVazia();
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}


class PilhaEstatica<T>  {
    private T[] elementos;
    private int tamanho;

    @SuppressWarnings("unchecked")
    public PilhaEstatica(int capacidadeMaxima) {
        this.elementos = (T[]) new Object[capacidadeMaxima];
        this.tamanho = 0;
    }

    public PilhaEstatica() {
        this(10);
    }

    
    public boolean estaVazia() {
        return this.tamanho() == 0;
    }

    
    public boolean estaCheia() {
        return this.tamanho() == this.elementos.length;
    }

    
    public void empilhar(T element) {
        if (estaCheia())
            throw new StackOverflowError();

        this.elementos[tamanho()] = element;
        this.tamanho++;
    }

    
    public T desempilhar() {
        if (estaVazia())
            throw new Error("Empty stack");
        T topElement = topo();
        this.tamanho--;
        return topElement;
    }

    
    public T topo() {

        return this.elementos[tamanho() - 1];
    }

    
    public int tamanho() {
        return this.tamanho;
    }

    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < tamanho(); i++) {
            if (i == tamanho() - 1) {
                s.append(this.elementos[i]);
            } else {
                s.append(this.elementos[i]);
                s.append(", ");
            }
        }
        s.append("]");
        return s.toString();
    }
}

