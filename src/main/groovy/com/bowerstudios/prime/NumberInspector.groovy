package com.bowerstudios.prime

import groovy.transform.CompileStatic

/**
 * Inspect a number for Primeness
 *
 */
@CompileStatic
interface NumberInspector {

    /**
     * Definition (from wikipedia):
     * In mathematics, a prime number (or a prime) is a natural number which has exactly
     * two distinct natural number divisors: 1 and itself. The first twenty-six prime numbers are:
     * 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
     * 97, 101

     * @param value
     * @return
     */
    boolean isPrime(int value)

}
