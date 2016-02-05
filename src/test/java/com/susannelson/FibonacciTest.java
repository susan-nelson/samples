package com.susannelson;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FibonacciTest {

    @Test
    public void testFib() throws Exception {

        Fibonacci fib = new Fibonacci();

        int result = fib.fibRecursive(6);

        assertEquals(result, 8);
    }

    @Test
    public void testFib2() throws Exception {

        Fibonacci fib = new Fibonacci();

        int result = fib.fibRecursive(2);

        assertEquals(result, 1);
    }

    @Test
    public void testFib1() throws Exception {

        Fibonacci fib = new Fibonacci();

        int result = fib.fibRecursive(1);

        assertEquals(result, 1);
    }

    @Test
    public void testFib_zero() throws Exception {

        Fibonacci fib = new Fibonacci();

        int result = fib.fibRecursive(0);

        assertEquals(result, 0);
    }

    @Test
    public void testFib_negative() throws Exception {

        Fibonacci fib = new Fibonacci();

        int result = fib.fibRecursive(-1);

        assertEquals(result, 0);
    }
}