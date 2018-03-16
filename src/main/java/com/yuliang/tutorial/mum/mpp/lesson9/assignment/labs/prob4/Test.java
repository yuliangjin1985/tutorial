package com.yuliang.tutorial.mum.mpp.lesson9.assignment.labs.prob4;

import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        final Stream<Integer> primes = Stream.iterate(2, n -> PrimesOrdinary.nextPrimeNumber(n));

        primes.limit(10).forEach(System.out::println);
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    class PrimeStream {
        public void printFirstNPrimes(int n) {

        }
    }

}
