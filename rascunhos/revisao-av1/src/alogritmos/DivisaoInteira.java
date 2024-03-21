package alogritmos;

public class DivisaoInteira {
    public static int divisaoInteira(int dividendo,int divisor){
        if(dividendo<divisor){
            return 0;
        }
        return 1+divisaoInteira(dividendo-divisor, divisor);
    }
}
