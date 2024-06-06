import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World!");
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
    public T busca(T elemento){
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
        }else{

            return busca(noArvore.direito, elemento);
        }
    }
    public void imprimirEmOrdem(){
        imprimirEmOrdem(raiz);
    }
    public void imprimirPosOrdem(){
        imprimePosOrdem(raiz);
    }
    public void imprimePreOrdem(){
        imprimePreOrdem(raiz);
    }
    private void imprimirEmOrdem(TreeNode<T> noArvore){
        if(noArvore==null){
            return;
        }
        this.imprimirEmOrdem(noArvore.esquerdo);
        System.out.print(noArvore.getElemento().toString()+" ");
        this.imprimirEmOrdem(noArvore.direito);
    }
    private void imprimePosOrdem(TreeNode<T> noArvore){
        if(noArvore==null){
            return;
        }
        this.imprimePosOrdem(noArvore.esquerdo);
        this.imprimePosOrdem(noArvore.direito);
        System.out.print(noArvore.getElemento().toString()+" ");
    }
    private void imprimePreOrdem(TreeNode<T> noArvore){
        if (noArvore==null) {
            return;
        }
        System.out.print(noArvore.getElemento().toString()+" ");
        this.imprimirEmOrdem(noArvore.esquerdo);
        this.imprimirEmOrdem(noArvore.direito);
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