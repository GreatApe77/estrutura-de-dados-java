import java.io.IOException;

class ListaDeNomes{

    String[] nomes;
    String[][] nomesPorLinha;
    
    ListaDeNomes(String[] nomes){
        this.nomes = nomes;
    }
    
    int getQuantidadeDeLinhas(){
        int numeroDeLinhas = 0;
        int[] tamanhos = new int[nomes.length];
        for (int i = 0; i < nomes.length; i++) {
            for (int j = 0; j < tamanhos.length; j++) {
                if(nomes[i].length() ==tamanhos[j]){
                    numeroDeLinhas++;
                }
            }
        }
        return numeroDeLinhas;
    }

    
}
public class Main {

    public static void main(String[] args) throws IOException {
      //  "sergio" "ana" maria carlos eva joaquim jo mara laura lucas ari paulo
    String[] nomesTeste = new String[]{"sergio", "ana", "maria", "carlos", "eva", "joaquim", "jo", "mara", "laura", "lucas", "ari", "paulo"};
       ListaDeNomes listaDeNomes = new ListaDeNomes(nomesTeste);
       System.out.println(listaDeNomes.getQuantidadeDeLinhas());
    }

}