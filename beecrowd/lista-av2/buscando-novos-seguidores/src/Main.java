import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String[] linha1 = scanner.next().split(" ");
        int N = Integer.parseInt(linha1[0]);
        int M = Integer.parseInt(linha1[1]);
        String[] linha2 = scanner.next().split(" ");
        int somatorioDeSeguidores = 0;

        for (int i = 0; i < 30; i++) {
            somatorioDeSeguidores = somatorioDeSeguidores + Integer.parseInt(linha2[i]);
        }
        int topoDaMedia = 0;
        if(topoDaMedia%30==0){
            topoDaMedia = somatorioDeSeguidores/30;
        }else{
            topoDaMedia = (somatorioDeSeguidores/30)+1;
        }

        int a = 4;
        int b = 10;
        int media = 0;
        if ((a + b) % 2 == 0) {
            media = (a + b) / 2;

        } else {
            media = ((a + b) / 2) + 1;
        }

        System.out.println(media);

    }
}
