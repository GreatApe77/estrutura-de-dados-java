package alogritmos;

public class Mdc {
    
    public static int mdc(int a , int b){
        if(b==0) return a;

        return mdc(b,a%b);
    }
}
