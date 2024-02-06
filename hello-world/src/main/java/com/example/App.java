package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Eleitor eleitor = new Eleitor("João", 16);
        System.out.println(eleitor.getNome());
    }
}
