package com.mateusnavarro77.recursao;

public class Mdc {
    public static int mdc(int a, int b) {
        if (b == 0) {
            return a;
        }

        return mdc(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(mdc(24, 18));
    }
}