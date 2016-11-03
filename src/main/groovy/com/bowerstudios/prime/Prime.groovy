package com.bowerstudios.prime

/**
 * Implementation for Exercise
 */
class Prime implements PrimeNumberGenerator{

    static void main(String[] args) {
        println 'Hello World!'
    }


    List<Integer> generate(int startingValue, int endingValue){
        List rangeOfVals = (startingValue..endingValue).step(1)

        return rangeOfVals.findAll{
            isPrime(it)
        }
    }

    boolean isPrime(int value){
        if(value < 2){
            return false
        }
        return true
    }

}
