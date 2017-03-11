package com.bowerstudios.prime.generatorImpl

import com.bowerstudios.prime.NumberInspector
import com.bowerstudios.prime.PrimeNumberGenerator
import groovy.transform.CompileStatic

/**
 * Implementation for App Number Exercise
 */
@CompileStatic
class PrimeNumberGeneratorRanged implements PrimeNumberGenerator{

    NumberInspector numberInspector

    /**
     * Generate a list of Primes starting with start value and ending with end value.
     *
     * Endpoints are candidates for prime evaluation.
     * Result is ordered
     * Inverse ranges are supported
     */
    List<Integer> generate(int startingValue, int endingValue) {
        List rangeOfVals = createRangeFrom(startingValue, endingValue)

        return rangeOfVals.findAll {
            numberInspector.isPrime(it)
        }
    }

    /**
     * Utility method to create a range of integers to test
     *
     * List is inclusive of endpoints
     * Result is ordered
     * Inverse ranges are supported
     */
    protected List<Integer> createRangeFrom(int startingValue, int endingValue) {
        Range vals
        if(startingValue > endingValue) {
            vals = (endingValue..startingValue)
        }else{
            vals = (startingValue..endingValue)
        }
        return vals.step(1)
    }

}
