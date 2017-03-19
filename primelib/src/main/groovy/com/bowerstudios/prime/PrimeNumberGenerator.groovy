package com.bowerstudios.prime

/**
 * Generate a list of Primes
 */
interface PrimeNumberGenerator {

    /**
     * Create a list of prime numbers between startingValue and endingValue
     */
    List<Integer> generate(int startingValue, int endingValue)

    /**
     * Allow the Number Inspection Strategy to be switched
     */
    void setNumberInspector(NumberInspector numberInspector)
}

