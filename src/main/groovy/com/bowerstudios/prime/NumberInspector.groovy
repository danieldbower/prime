package com.bowerstudios.prime

import groovy.transform.CompileStatic

/**
 * Inspect a number
 *
 * Could subclass this to take advantage of concurrency or some such
 */
@CompileStatic
class NumberInspector {

    /**
     * Definition (from wikipedia):
     * In mathematics, a prime number (or a prime) is a natural number which has exactly
     * two distinct natural number divisors: 1 and itself. The first twenty-six prime numbers are:
     * 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
     * 97, 101

     * @param value
     * @return
     */
    boolean isPrime(int value) {
        // Eliminate integers less than 2
        if(value < 2){
            return false
        }

        // 2 is okay, the only even prime
        if(value == 2) {
            return true
        }

        // all other evens can be dropped immediately
        if(value % 2 == 0) {
            return false
        }

        int step = 3
        while(step <= Math.sqrt(value)) {
            if((value % step) == 0 ) {
                return false
            }

            //skip the even, and go to the next odd
            step += 2
        }

        return true
    }

}
