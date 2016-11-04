package com.bowerstudios.prime

/**
 * Interface required by exercise
 */
interface PrimeNumberGenerator {

    /**
     * Create a list of prime numbers between startingValue and endingValue
     */
    List<Integer> generate(int startingValue, int endingValue)

    /**
     * Check if a given number is prime
     */
    boolean isPrime(int value)

    /**
     * Allow the Number Inspection Strategy to be switched
     */
    void setNumberInspector(NumberInspector numberInspector)
}

