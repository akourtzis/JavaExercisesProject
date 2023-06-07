package com.kourtzis.loops;

public class ForLoops {
    public static void main(String[] args) {

    }

    // Aufgabe 2
    public static int Sum(int n) {
        if(n < 0) {
            return n;
        }
        int sum = 0;
        for(int it = 0; it < n; ++it) {
            sum += it;
        }

        return sum;
    }

    // Aufgabe 3
    public static int factorial(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("Number must be a positive number");
        }

        if(n == 0) {
            return 0;
        }

        int res = 1;
        for(int it = 1; it < n; ++it) {
            res *= it;
        }

        return res;
    }

    // Aufgabe 4
    public static int fibonacci(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("Number must be a positive number");
        }

        if(n < 2) {
            return 1;
        }

        int res = 0;
        for(int it = 0; it < n; ++it) {
            res += it;
        }

        return res;
    }
}
