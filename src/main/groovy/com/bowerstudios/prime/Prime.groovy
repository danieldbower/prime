package com.bowerstudios.prime

/**
 * Implementation for Exercise
 */
class Prime implements PrimeNumberGenerator{

    static void main(String[] args) {
        println 'Hello World!'
    }

    /**
     *
     * Endpoints are candidates
     * Result is ordered
     * Inverse ranges are supported
     */
    List<Integer> generate(int startingValue, int endingValue) {
        List rangeOfVals = createRangeFrom(startingValue..endingValue)

        return rangeOfVals.findAll{
            isPrime(it)
        }
    }

    boolean isPrime(int value) {
        if(value < 2){
            return false
        }
        return true
    }

    /**
     * List is inclusive of endpoints
     * Result is ordered
     * Inverse ranges are supported
     */
    List<Integer> createRangeFrom(int startingValue, int endingValue) {
        Range vals
        if(startingValue>endingValue) {
            vals = (endingValue..startingValue)
        }else{
            vals = (startingValue..endingValue)
        }
        return vals.step(1)
    }

}
