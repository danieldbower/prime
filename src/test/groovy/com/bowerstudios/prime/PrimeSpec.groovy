package com.bowerstudios.prime

import spock.lang.*

/**
 * Test Specification for Prime
 */
class PrimeSpec extends Specification {

    def "Sanity check of environment"() {
        expect:
        true
    }

    def "Sanity check main and code reporting"() {
        Prime.main(['a', 'b', 'c'] as String[])
        expect:
        true
    }

    def "create an ordered range"(int fromVal, int toVal, List result) {
        Prime prime = new Prime()

        expect:
        result == prime.createRangeFrom(fromVal,toVal)

        where:
        fromVal | toVal | result
        0 | 0 | [0]                         //zero to zero
        -1 | 0 | [-1, 0]                    //negative included
        -3 | 3 | [-3, -2, -1, 0, 1, 2, 3]   //negative to positive
        3 | 0 | [0, 1, 2, 3]                //inverse
    }

    def "negatives, zero and 1 are not prime" () {
        Prime prime = new Prime()

        expect:
        !prime.isPrime(0)
        !prime.isPrime(1)
        !prime.isPrime(-1)
        !prime.isPrime(-10)
        !prime.isPrime(-15)
    }

    def "2 is the only even prime" () {
        Prime prime = new Prime()

        expect:
        prime.isPrime(2)

        [2,4,6,8,16,32,64,128,256,512,1024].each{
            !prime.isPrime(it)
        }
    }

    def "first 26 primes" () {
        Prime prime = new Prime()

        expect:
        prime.isPrime(3)
    }

}
