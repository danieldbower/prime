package com.bowerstudios.prime.inspectorImpl

import com.bowerstudios.prime.NumberInspector
import groovy.transform.CompileStatic

/**
 * Inspect a number
 */
@CompileStatic
class SingleThreadNumberInspector implements NumberInspector{

    /**
     * Calculate whether this number is prime
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
