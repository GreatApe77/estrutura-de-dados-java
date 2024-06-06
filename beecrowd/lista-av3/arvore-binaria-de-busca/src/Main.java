import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // int[] elm = {5,2,7};
        // ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<Integer>();
        //// for (int i : elm) {
        // arvore.insere(i);
        // }
        // arvore.imprimirPosOrdem();
        // arvore.imprimePreOrdem();
        // System.out.println();
        // arvore.imprimirEmOrdem();
        // System.out.println();
        // arvore.imprimirPosOrdem();
        Scanner s = new Scanner(System.in);
        int C = s.nextInt();
        for (int i = 0; i < C; i++) {
            int n = s.nextInt();
            s.nextLine();
            String[] linha = s.nextLine().split(" ");
            ArvoreBinariaBusca<Integer> arvore = new ArvoreBinariaBusca<Integer>();
            for (int j = 0; j < n; j++) {
                arvore.insere(Integer.parseInt(linha[j]));
            }
            System.out.println("Case " + (i + 1) + ": ");
            System.out.print("Pre.: ");
            arvore.imprimePreOrdem();
            System.out.println();
            System.out.print("In..: ");
            arvore.imprimirEmOrdem();
            System.out.println();
            System.out.print("Post: ");
            arvore.imprimirPosOrdem();
            System.out.println();
            System.out.println();
        }
        s.close();
    }
}

class ArvoreBinariaBusca<T extends Comparable<T>> {
    private TreeNode<T> raiz;

    private int tamanho;

    public ArvoreBinariaBusca() {
        this.raiz = null;
        this.tamanho = 0;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public boolean estaVazia() {
        return this.raiz == null;
    }

    public void insere(T elemento) {
        this.raiz = insere(raiz, elemento);
    }

    public T busca(T elemento) {
        return busca(raiz, elemento);
    }

    private TreeNode<T> insere(TreeNode<T> noArvore, T elemento) {
        if (noArvore == null) {
            noArvore = new TreeNode<T>(elemento);
            return noArvore;
        }
        // igual a zero: elementos iguais
        // A.compareTo(B) maior que 0: elemento A eh maior que o B
        // A.compareTo(B) menor que 0: elemento B eh maior
        if (elemento.compareTo(noArvore.getElemento()) > 0) {
            // ELEMENTO MAIOR QUE RAIZ
            noArvore.direito = insere(noArvore.direito, elemento);
        } else if (elemento.compareTo(noArvore.getElemento()) < 0) {
            // ELEMENTO MENOR QUE RAIZ
            noArvore.esquerdo = insere(noArvore.esquerdo, elemento);
        }
        return noArvore;
    }

    private T busca(TreeNode<T> noArvore, T elemento) {
        if (noArvore == null) {
            return null;
        }
        // SAO IGUAIS
        if (noArvore.getElemento().compareTo(elemento) == 0) {
            return noArvore.getElemento();
        }
        if (elemento.compareTo(noArvore.getElemento()) < 0) {
            return busca(noArvore.esquerdo, elemento);
        } else {

            return busca(noArvore.direito, elemento);
        }
    }

    public void imprimirEmOrdem() {
        StringBuilder s = new StringBuilder();
        imprimirEmOrdem(raiz, s);
        System.out.print(s.toString().trim());
    }

    public void imprimirPosOrdem() {
        StringBuilder s = new StringBuilder();

        imprimePosOrdem(raiz, s);
        System.out.print(s.toString().trim());

    }

    public void imprimePreOrdem() {
        StringBuilder s = new StringBuilder();

        imprimePreOrdem(raiz, s);
        System.out.print(s.toString().trim());

    }

    private void imprimirEmOrdem(TreeNode<T> noArvore, StringBuilder s) {
        if (noArvore == null) {
            return;
        }
        this.imprimirEmOrdem(noArvore.esquerdo, s);
        s.append(noArvore.getElemento().toString());
        s.append(" ");
        this.imprimirEmOrdem(noArvore.direito, s);
    }

    private void imprimePosOrdem(TreeNode<T> noArvore, StringBuilder s) {
        if (noArvore == null) {
            return;
        }
        this.imprimePosOrdem(noArvore.esquerdo, s);
        this.imprimePosOrdem(noArvore.direito, s);
        s.append(noArvore.getElemento().toString());
        s.append(" ");
    }

    private void imprimePreOrdem(TreeNode<T> noArvore, StringBuilder s) {

        if (noArvore == null) {
            return;
        }
        s.append(noArvore.getElemento().toString());
        s.append(" ");
        this.imprimePreOrdem(noArvore.esquerdo, s);
        this.imprimePreOrdem(noArvore.direito, s);
    }
}

class TreeNode<T extends Comparable<T>> {
    protected T elemento;
    protected TreeNode<T> esquerdo;
    protected TreeNode<T> direito;

    public TreeNode(T elemento) {
        this.elemento = elemento;
        this.direito = null;
        this.esquerdo = null;
    }

    public TreeNode<T> getDireito() {
        return direito;
    }

    public TreeNode<T> getEsquerdo() {
        return esquerdo;
    }

    public void setDireito(TreeNode<T> direito) {
        this.direito = direito;
    }

    public void setEsquerdo(TreeNode<T> esquerdo) {
        this.esquerdo = esquerdo;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public T getElemento() {
        return elemento;
    }

}