public class Crescente {
    public static void crescente(int n) {

        if(n<=0){
            System.out.println(n);
            return;
        }
        crescente(n-1);
        System.out.println(n);
    }
}
