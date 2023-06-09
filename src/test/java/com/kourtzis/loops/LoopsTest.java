package com.kourtzis.loops;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoopsTest {
    @Test
    public void arraySumTest() {
        double[] arr = {1.1, 2.2, 3.3};
        double expectedResult = 6.6;

        double actualResult = Loops.arraySum(arr);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
	@CsvSource({"2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97"})
    public void isPrimeNumberTest(int number) {
        assertTrue(Loops.isPrime(number));
    }

    @ParameterizedTest
    @CsvSource({"4, 6, 8, 10, 12, 9, 18, 36, 45"})
    public void isNotPrimeNumberTest(int number) {
        assertFalse(Loops.isPrime(number));
    }

    @ParameterizedTest
    @CsvSource({
        "18,12,6",
        "12,18,6",
        "65,143,13"
    })
    public void ggtTest(int n, int m, int expectedResult) {
        assertEquals(expectedResult, Loops.ggt(n, m));
    }

    @ParameterizedTest
    @CsvSource({
        "3,6",
        "4,10",
        "5,15",
        "6,21"
    })
    public void forLoopSumTest(int n, int expectedResult) {
        assertEquals(expectedResult, ForLoops.sum(n));
    }

    @ParameterizedTest
    @CsvSource({
        "3,6",
        "4,24",
        "5,120"
    })
    public void forLoopFactorialTest(int n, int expectedResult) {
        assertEquals(expectedResult, ForLoops.factorial(n));
    }

    @ParameterizedTest
    @CsvSource({
        "0,0",
        "1,1",
        "2,1",
        "3,2",
        "4,3",
        "5,5",
        "6,8",
        "7,13",
        "8,21",
        "9,34",
        "10,55",
        "11,89",
        "12,144",
        "13,233",
        "14,377"

    })
    public void forLoopFibTest(int n, int expectedResult) {
        assertEquals(expectedResult, ForLoops.fibonacci(n));
    }
}
