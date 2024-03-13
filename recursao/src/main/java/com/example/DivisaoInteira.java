package com.example;

public class DivisaoInteira {
    
    public static int divisaoInteira(int dividendo,int divisor){
        if(dividendo< divisor){
            return 0;
        }
        return 1+divisaoInteira(dividendo-divisor, divisor);
    }
    public static void main(String[] args) {
        System.out.println(divisaoInteira(70, 2));
    }
}
