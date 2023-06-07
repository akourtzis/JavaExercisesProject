package com.kourtzis.loops;

public class ForLoops {
    public static void main(String[] args) {

    }

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

    public int factorial(int n) {
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
}
