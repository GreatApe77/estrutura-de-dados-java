package vetor;



public class Vetor  {
    private int[] elementos;
    private int tamanho;
   

    public Vetor(int capacidadeTotal) {
        this.elementos = new int[capacidadeTotal];
        
        this.tamanho = 0;
    }
    private void aumentaCapacidade(){
        if(estaCheio()){
            int[] elementosNovos = new int[this.elementos.length*2];
            for (int i = 0; i <this.tamanho; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }
    
    public boolean adicionarElementoNoFinal(int elemento) {
        aumentaCapacidade();
        int posicao = this.tamanho;
        this.setElementoEmPosicao(posicao, elemento);
        this.tamanho++;
        return true;
    }

    
    private void setElementoEmPosicao(int posicao, int elemento) {
        elementos[posicao] = elemento;
    }

    public boolean removerElemento(int elemento){
        int indice = indiceDoElemento(elemento);
        if( indice==-1) return false;
        removerElementoEmPosicao(indice);
        return true;
    }
    public void removerElementoEmPosicao(int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho))
        throw new IllegalArgumentException("Posicao Invalida");

        for (int i = posicao; i < this.tamanho-1; i++) {
            this.elementos[i] = this.elementos[i+1];
        }
        this.tamanho--;
    }

    
    public int buscarElementoEmPosicao(int posicao) {
        if (!(posicao >= 0 && posicao < this.tamanho))
            throw new IllegalArgumentException("Posicao Invalida");
        return this.elementos[posicao];
    }

    
    public int indiceDoElemento(int elemento) {
        // busca sequencial nao otimizada
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    
    public boolean contemElemento(int elemento) {
        // busca sequencial nao otimizada
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i] == elemento) {
                return true;
            }
        }
        return false;
    }

    
    public int tamanho() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tamanho'");
    }

    
    public String toString() {
        StringBuilder arrayString = new StringBuilder();
        arrayString.append("[");
        for (int i = 0; i < this.tamanho - 1; i++) {
            arrayString.append(this.elementos[i]);
            arrayString.append(", ");

        }
        if (this.tamanho > 0) {
            arrayString.append(this.elementos[this.tamanho - 1]); // ultimo elemento
        }
        arrayString.append("]");
        return arrayString.toString();
    }

    
    public void adicionarElementoNoComeco(int elemento) {
        adiciona(0, elemento);
    }

    public int getTamanho() {
        return tamanho;
    }

    
    public boolean estaCheio() {
        return tamanho == this.elementos.length;
    }

    
    public boolean estaVazio() {
        return tamanho == 0;
    }

    
    public boolean adiciona(int posicao, int elemento) {
        if (!(posicao >= 0 && posicao < this.tamanho))
            throw new IllegalArgumentException("Posicao Invalida");
        this.aumentaCapacidade();
        for (int i = this.tamanho-1; i>= posicao ; i--) {
            this.elementos[i+1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;
        return true;
    }
}
