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
}
