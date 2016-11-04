package com.bowerstudios.prime

import spock.lang.Shared
import spock.lang.Specification

/**
 * Test Specification for PrimeNumberGeneratorRanged
 */
class PrimeNumberGeneratorRangedSpec extends Specification {

    @Shared
    //Strongly typing the reference so we can access functions outside of the interface
    PrimeNumberGeneratorRanged primeNumberGenerator = new PrimeNumberGeneratorRanged()


    /**
     * This test is duplicated in the NumberInspectorSpec, but we'll be calling it through the facade
     * in PrimeNumberGenerator, necessary to get our 100% code coverage
     */
    def "first 26 primes" () {
        expect:
        NumberInspectorSpec.first26.each {
            assert primeNumberGenerator.isPrime(it)
        }
    }

    def "generate - put it all together" () {
        expect:
        [2,3,5] == primeNumberGenerator.generate(0, 6)
        NumberInspectorSpec.first26 == primeNumberGenerator.generate(0, 102)
    }

    def "create an ordered range"(int fromVal, int toVal, List result) {
        expect:
        result == primeNumberGenerator.createRangeFrom(fromVal,toVal)

        where:
        fromVal | toVal | result
        0  | 0  | [0]                         //zero to zero
        -1 | 0  | [-1, 0]                     //negative included
        -3 | 3  | [-3, -2, -1, 0, 1, 2, 3]    //negative to positive
        3  | 0  | [0, 1, 2, 3]                //inverse
        0  | -3 | [-3, -2, -1, 0]             //inverse negative
    }

    def "Set a different Number Inspector"() {
        primeNumberGenerator.numberInspector = new NumberInspector()
        expect:
        primeNumberGenerator.numberInspector
    }
}
