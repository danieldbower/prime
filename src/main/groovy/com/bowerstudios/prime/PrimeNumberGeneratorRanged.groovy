package com.bowerstudios.prime

import groovy.transform.CompileStatic

/**
 * Implementation for Prime Number Exercise
 */
@CompileStatic
class PrimeNumberGeneratorRanged implements PrimeNumberGenerator{

    NumberInspector numberInspector = new NumberInspector() //default implementation

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
     * Perhaps this method doesn't belong in that interface?
     * Recommend you use the NumberInspector instead.  Although we could retain this method as a
     * part of a "single" api point.
     *
     * Extracting it out, we can easily swap it for other methods of searching,
     * such as a concurrent example.
     */
    boolean isPrime(int value) {
        return numberInspector.isPrime(value)
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
