# Recursão

Algoritmos abordados: Fibonacci e Fatorial

## Fibonacci

A sequência de Fibonacci é uma sequência de números inteiros, começando normalmente por 0 e 1, na qual, cada termo subsequente corresponde à soma dos dois anteriores. A sequência recebeu o nome do matemático italiano Leonardo de Pisa, mais conhecido por Fibonacci, que descreveu, no ano de 1202, o crescimento de uma população de coelhos, a partir desta sequência.

```java
    public static int fibonacci(int n){
        if(n==0) return 0; // Caso de Parada
        if(n==1) return 1; // Caso de Parada

        return fibonacci(n-1) + fibonacci(n-2); // Caso de Recursão. Recursão Binária
    }
```

## Fatorial

O fatorial de um número natural n, representado por n!, é a multiplicação de todos os inteiros positivos menores ou iguais a n. O fatorial de 0 é 1.

```java
    public static int fatorial(int n){
        if(n==0) return 1; // Caso de Parada
        if(n==1) return 1; // Caso de Parada

        return n*fatorial(n-1); //Casos de Recursão. Recursão linear
    }
```
