package com.mateusnavarro77.recursao;

import static org.junit.Assert.assertTrue;


import org.junit.Test;

public class FibonacciTest {
    
    @Test
    public void testFibonacci() {
        
        assertTrue(Fibonacci.fibonacci(5)==5);
    }
}