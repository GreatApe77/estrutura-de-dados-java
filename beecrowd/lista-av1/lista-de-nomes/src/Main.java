import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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

class Nome {
    private String nome;
    private int tamanho;

    public Nome(String nome) {
        this.nome = nome;
        this.tamanho = nome.length();
    }

    @Override
    public boolean equals(Object obj) {
        Nome nome = (Nome) obj;
        return nome.getTamanho() == this.getTamanho();
    }

    public String getNome() {
        return nome;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return "nome: " + this.nome;
    }
}

class ListaDeNomes {

    Lista<Nome> todosOsNomes;

    public ListaDeNomes(Lista<Nome> nomes) {
        this.todosOsNomes = nomes;
    }

    private void _criarLinhasrecursivo(Lista<Lista<Nome>> listaBidimensional, int posicao) {
        if (posicao == pegarTamanhoDaListaBiDimensional()) {
            return;
        }
        listaBidimensional.adicionarElementoNoFinal(new Lista<Nome>());
        _criarLinhasrecursivo(listaBidimensional, posicao + 1);
    }

    private void _adicionarElementosRecursivo(Lista<Lista<Nome>> listaBidimensional, int j, Nome nome) {
        if (j == listaBidimensional.tamanho()) {
            return;
        }
        boolean contem = listaBidimensional.pesquisarPorIndice(j).contem(nome);
        if (!contem) {
            listaBidimensional.pesquisarPorIndice(j).adicionarElementoNoFinal(nome);
            return;
        }
        _adicionarElementosRecursivo(listaBidimensional, j + 1, nome);
    }

    private void _iterarSobreNomesRecursivo(Lista<Lista<Nome>> listaBidimensional, int i, int j) {
        if (i == todosOsNomes.tamanho()) {
            return;
        }
        Nome nome = this.todosOsNomes.pesquisarPorIndice(i);
        _adicionarElementosRecursivo(listaBidimensional, j, nome);
        _iterarSobreNomesRecursivo(listaBidimensional, i + 1, j);

    }

    public Lista<Lista<Nome>> getListaBiDimensional() {
        Lista<Lista<Nome>> listaBidimensional = new Lista<Lista<Nome>>();
        // ITERATIVO
        /*
         * for (int i = 0; i < pegarTamanhoDaListaBiDimensional(); i++) {
         * listaBidimensional.adicionarElementoNoFinal(new Lista<Nome>());
         * }
         */
        // RECURSIVO
        int iCriarLinhas = 0;
        _criarLinhasrecursivo(listaBidimensional, iCriarLinhas);

        int j = 0;
        int i = 0;
        _iterarSobreNomesRecursivo(listaBidimensional, i, j);
        // for (int i = 0; i < this.todosOsNomes.tamanho(); i++) {
        // Nome nome = this.todosOsNomes.pesquisarPorIndice(i);
        // ITERATIVO
        /*
         * for (int j = 0; j < listaBidimensional.tamanho(); j++) {
         * boolean contem = listaBidimensional.pesquisarPorIndice(j).contem(nome);
         * if (!contem) {
         * listaBidimensional.pesquisarPorIndice(j).adicionarElementoNoFinal(nome);
         * break;
         * }
         * 
         * }
         */
        // _adicionarElementosRecursivo(listaBidimensional, j+1, nome);
        // }
        return listaBidimensional;
    }

    private void _trocarVariaveis(int j2, Lista<Nome> linha) {
        if (j2 == linha.tamanho() - 1) {
            return;
        }
        if (linha.pesquisarPorIndice(j2).getTamanho() > linha.pesquisarPorIndice(j2 + 1).getTamanho()) {
            Nome auxiliar = new Nome(linha.pesquisarPorIndice(j2 + 1).getNome());
            linha.setElemento(j2 + 1, linha.pesquisarPorIndice(j2));
            linha.setElemento(j2, auxiliar);
        }
        _trocarVariaveis(j2 + 1, linha);
    }

    private void _iterarEmLinhaParaOrdenar(int j, Lista<Nome> linha, int j2) {
        if (j == linha.tamanho()) {
            return;
        }
        _trocarVariaveis(j2, linha);
        _iterarEmLinhaParaOrdenar(j + 1, linha, j2);
    }

    private void _iterarEmListaBiDimensional(int i, int j, int j2, Lista<Lista<Nome>> listaBiDimensional) {
        if (i == listaBiDimensional.tamanho()) {
            return;
        }
        Lista<Nome> linha = listaBiDimensional.pesquisarPorIndice(i);
        _iterarEmLinhaParaOrdenar(j, linha, j2);
        _iterarEmListaBiDimensional(i + 1, j, j2, listaBiDimensional);

    }

    public Lista<Lista<Nome>> getListaOrdenada() {
        Lista<Lista<Nome>> listaBiDimensional = getListaBiDimensional();
        int j2 = 0;
        int i = 0;
        int j = 0;

        _iterarEmListaBiDimensional(i, j, j2, listaBiDimensional);
        return listaBiDimensional;
    }

    public void printarFormatado() {
        Lista<Lista<Nome>> listaOrdenada = this.getListaOrdenada();
        int j = 0;
        int i = 0;
        _iterarParaPrintar(listaOrdenada, i, j);
        /* for (int i = 0; i < listaOrdenada.tamanho(); i++) {
            if (listaOrdenada.pesquisarPorIndice(i).tamanho() > 0) {

                
                  for (int j = 0; j < listaOrdenada.pesquisarPorIndice(i).tamanho(); j++) {
                  String virgula = j < listaOrdenada.pesquisarPorIndice(i).tamanho() - 1 ? ", "
                 : "";
                 linhaFormatada = linhaFormatada
                  + listaOrdenada.pesquisarPorIndice(i).pesquisarPorIndice(j).getNome() +
                  virgula;
                  
                  }
                 

                String linhaMontada = _concatenarStrings(listaOrdenada, i, j, "");

                System.out.println(linhaMontada);
            }
        } */
    }

    private void _iterarParaPrintar(Lista<Lista<Nome>> listaOrdenada,int i,int j) {
        if(i==listaOrdenada.tamanho()){
            return;
        }
        if (listaOrdenada.pesquisarPorIndice(i).tamanho() > 0) {
            String linhaMontada = _concatenarStrings(listaOrdenada, i, j, "");
            System.out.println(linhaMontada);
        }
        _iterarParaPrintar(listaOrdenada, i+1, j);

    }

    private String _concatenarStrings(Lista<Lista<Nome>> listaOrdenada, int i, int j, String linhaFormatada) {
        if (j == listaOrdenada.pesquisarPorIndice(i).tamanho()) {
            return linhaFormatada;
        }
        String virgula = j < listaOrdenada.pesquisarPorIndice(i).tamanho() - 1 ? ", " : "";
        linhaFormatada = linhaFormatada + listaOrdenada.pesquisarPorIndice(i).pesquisarPorIndice(j).getNome() + virgula;
        return _concatenarStrings(listaOrdenada, i, j + 1, linhaFormatada);
    }

    public Lista<Nome> getListaSemRepeticao() {
        Lista<Nome> listaSemDuplicatas = new Lista<Nome>();

        _adicionarNovos(listaSemDuplicatas, 0);
        return listaSemDuplicatas;
    }

    private void _adicionarNovos(Lista<Nome> listaSemDuplicatas, int indiceDePartida) {
        if (indiceDePartida == this.todosOsNomes.tamanho()) {
            return;
        }

        Nome nome = this.todosOsNomes.pesquisarPorIndice(indiceDePartida);
        boolean existeNaLista = listaSemDuplicatas.contem(nome);
        if (!existeNaLista) {

            listaSemDuplicatas.adicionarElementoNoFinal(nome);
            _adicionarNovos(listaSemDuplicatas, indiceDePartida + 1);
        } else {

            _adicionarNovos(listaSemDuplicatas, indiceDePartida + 1);
        }
    }

    public int pegarTamanhoDaListaBiDimensional() {
        return this.todosOsNomes.tamanho() - this.getListaSemRepeticao().tamanho();
    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Lista<Nome> nomesDaEntrada = new Lista<Nome>(1000);
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            String nomeTitulo = scanner.next();
            nomesDaEntrada.adicionarElementoNoFinal(new Nome(nomeTitulo));
        }
        ListaDeNomes listaDeNomes = new ListaDeNomes(nomesDaEntrada);
        listaDeNomes.printarFormatado();

        scanner.close();
        // "sergio" "ana" maria carlos eva joaquim jo mara laura lucas ari paulo
        //String[] nomesTeste = new String[] { "sergio", "ana", "maria", "carlos", "eva", "joaquim", "jo", "mara",
        //        "laura", "lucas", "ari", "paulo" };

        //Lista<Nome> lista = new Lista<Nome>();
        //for (String nome : nomesTeste) {
        //    lista.adicionarElementoNoFinal(new Nome(nome));
        //}
        //ListaDeNomes listaDeNomes = new ListaDeNomes(lista);
        // System.out.println(lista.contem(new Nome("Yan")));
        //listaDeNomes.printarFormatado();
        // Nome nome1 = new Nome("ana");
        // Nome nome2 = new Nome("yan");
        // System.out.println(nome1.equals(nome2));
    }

}