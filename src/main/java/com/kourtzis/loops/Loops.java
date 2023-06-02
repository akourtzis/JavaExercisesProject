package com.kourtzis.loops;

public class Loops {
    public static void main(String[] args) {

    }

    //Aufgabe 2
    public static double arraySum(double[] arr) {
        double result = 0;
        int begin = 0;
        int end = arr.length;
        while(begin < end) {
            result += arr[begin];
            ++begin;
        }

        return result;
    }

    //Aufgabe 3
    public static void primeNumbers(int n) {
        if(n < 2) {
            return ;
        }

        int it = 2;
        System.out.print("Prime numbers from 2 to " + n + ": ");
        while(it <= n) {
            if(isPrime(it)) {
                System.out.print( it + " ");
            }

            ++it;
        }
    }

    public static boolean isPrime(int number) {
        int it = 2;
        while(it <= number) {
            if(number % it == 0 && number != it) {
                return false;
            }

            ++it;
        }

        return true;
    }

    //Aufgabe 4
    public static int ggt(int n, int m) {
        if(n == 0) {
            return Math.abs(m);
        }
        if(m == 0) {
            return Math.abs(n);
        }

        n = Math.abs(n);
        m = Math.abs(m);

        if(m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }

        while(n != 0) {
            int tmp = m % n;
            m = n;
            n = tmp;
        }

        return m;
    }
}
