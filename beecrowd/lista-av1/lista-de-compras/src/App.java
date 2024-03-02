class Lista<T> {
    private T[] elementos;
    private int tamanho;
    private int tamanhoPadrao = 5;

    @SuppressWarnings("unchecked")
    public Lista(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public Lista(T[] elementosIniciais) {
        this.elementos = elementosIniciais;
        this.tamanho = elementosIniciais.length;
    }

    @SuppressWarnings("unchecked")
    public Lista() {
        this.elementos = (T[]) new Object[this.tamanhoPadrao];
        this.tamanho = 0;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public void adicionarElemento(T elemento, int posicao) {
        _lancarErroDePosicaoInvalida(posicao);
        _aumentarCapacidade();
        // inserir x na posicao 4
        // [a b c d e e f] t = 6 i=4
        for (int i = tamanho - 1; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        // [a b c d x e f]
        setElemento(posicao, elemento);
        this.tamanho++;
    }

    public void setElemento(int posicao, T elemento) {
        this.elementos[posicao] = elemento;
    }

    @SuppressWarnings("unchecked")

    public void limpar() {
        this.elementos = (T[]) new Object[tamanhoPadrao];
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return _estaVazia();
    }

    // privados
    private boolean _posicaoValida(int posicao) {
        return posicao >= 0 && posicao < tamanho;
    }

    private void _lancarErroDePosicaoInvalida(int posicao) throws IllegalArgumentException {
        if (!_posicaoValida(posicao))
            throw new IllegalArgumentException("Tentando acessar posicao invalida");
    }

    private void _aumentarCapacidade() {
        if (_estaCheia()) {
            int capacidadeAtual = this.elementos.length;
            int novaCapacidade = capacidadeAtual * 2;
            @SuppressWarnings("unchecked")
            T[] novoArrayMaior = (T[]) new Object[novaCapacidade];
            for (int i = 0; i < this.tamanho; i++) {
                novoArrayMaior[i] = this.elementos[i];
            }
            this.elementos = novoArrayMaior;
        }
    }

    private boolean _estaCheia() {
        return this.tamanho == this.elementos.length;
    }

    private boolean _estaVazia() {
        return this.tamanho == 0;
    }

    public void adicionarElementoNoFinal(T elemento) {
        _aumentarCapacidade();
        setElemento(this.tamanho, elemento);
        this.tamanho++;
    }

    public T pesquisarPorIndice(int posicao) throws IllegalArgumentException {
        _lancarErroDePosicaoInvalida(posicao);
        return this.elementos[posicao];
    }

    // Big O(n)
    public int pesquisarIndiceDe(T elemento) {

        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }

        }
        return -1;
    }

    public int pesquisarUltimoIndiceDe(T elemento) {

        for (int i = this.tamanho - 1; i >= 0; i--) {
            if (this.elementos[i].equals(elemento)) {
                return i;
            }

        }
        return -1;
    }

    public boolean contem(T elemento) {
        return pesquisarIndiceDe(elemento) != -1;
    }

    public String toString() {
        StringBuilder vetorEmString = new StringBuilder();
        vetorEmString.append("[");

        for (int i = 0; i < this.tamanho; i++) {
            vetorEmString.append(this.elementos[i]);
            if (i < this.tamanho - 1) {
                vetorEmString.append(", ");
            }
        }
        vetorEmString.append("]");

        return vetorEmString.toString();
    }

    public boolean removerPorPosicao(int posicao) {
        _lancarErroDePosicaoInvalida(posicao);
        // [a b c e f ]|f] i=4
        for (int i = posicao; i < tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        this.tamanho--;
        return true;
    }

    public boolean removerElemento(T elemento) {
        int posicao = pesquisarIndiceDe(elemento);
        if (posicao == -1)
            return false;
        return this.removerPorPosicao(posicao);
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] formatoArray = (T[]) new Object[this.tamanho];
        for (int i = 0; i < formatoArray.length; i++) {
            formatoArray[i] = this.elementos[i];
        }
        return formatoArray;
    }
}

class ListaDeCompras {

    Lista<String> items;

    public ListaDeCompras(String[] listaDeElementos){
        items = new Lista<String>(listaDeElementos);
    }
    


    public Lista<String> getListaSemRepeticao() {
        Lista<String> listaSemDuplicatas = new Lista<String>();

        _adicionarNovos(listaSemDuplicatas, 0);
        return listaSemDuplicatas;
    }
    private void _adicionarNovos(Lista<String> listaSemDuplicatas, int indiceDePartida) {
        if (indiceDePartida == this.items.tamanho()) {
            return;
        }

        String pokemon = this.items.pesquisarPorIndice(indiceDePartida);
        boolean existeNaLista = listaSemDuplicatas.contem(pokemon);
        if (!existeNaLista) {

            listaSemDuplicatas.adicionarElementoNoFinal(pokemon);
            _adicionarNovos(listaSemDuplicatas, indiceDePartida + 1);
        } else {

            _adicionarNovos(listaSemDuplicatas, indiceDePartida + 1);
        }
    }
    public static String escolherPrimeiroEmOrdemAlfabetica(String a, String b) {
        if (a.compareTo(b) < 0) {
            return a;
        }
        return b;
    }
    public static boolean vemPrimeiroNoAlfabeto(String a, String b) {
        if (a.compareTo(b) < 0) {
            return true; // String A vem primeiro que a B
        }
        return false; //B vem primeiro que a A
    }
    public Lista<String> getListaDeComprasOrdenada(){
        Lista<String> semDuplicatas = getListaSemRepeticao();
        int i = 0;
        int j = 0;
        
        _percorrerLista(semDuplicatas, i, j);
        return semDuplicatas;
    }

    private void _percorrerLista(Lista<String> semDuplicatas,int i,int j){
        if(i==semDuplicatas.tamanho()){
            return;
        }
        
        _ordenarLista(semDuplicatas, i, j);
        _percorrerLista(semDuplicatas, i+1, j);

    }

    private void _ordenarLista(Lista<String> semDuplicatas,int i,int j){
        if(j==semDuplicatas.tamanho()-1){
            return;
        }
        if(!vemPrimeiroNoAlfabeto(semDuplicatas.pesquisarPorIndice(j), semDuplicatas.pesquisarPorIndice(j+1))){
            String variavelAuxiliar = semDuplicatas.pesquisarPorIndice(j);
            semDuplicatas.setElemento(j, semDuplicatas.pesquisarPorIndice(j+1));
            semDuplicatas.setElemento(j+1, variavelAuxiliar);
        }
        _ordenarLista(semDuplicatas, i, j+1);
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        ///String[] entradaDeDados = new String[]{"laranja", "pera", "laranja", "pera" ,"pera"};
        //String[] entradaDeDados = new String[]{"carne", "laranja", "suco", "picles" ,"laranja","picles"};
        //ListaDeCompras listaDeCompras = new ListaDeCompras(entradaDeDados);
        //System.out.println(listaDeCompras.getListaDeComprasOrdenada());
        
    }
}
