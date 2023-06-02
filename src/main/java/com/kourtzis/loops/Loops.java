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
}
