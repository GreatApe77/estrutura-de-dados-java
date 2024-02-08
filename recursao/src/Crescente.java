public class Crescente {
    public static void crescente(int n, int limit) {

        System.out.println(n);
        if (n == limit)
            return;
        crescente(n + 1, limit);
    }
}
