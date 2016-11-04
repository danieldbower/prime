package com.bowerstudios.prime

import spock.lang.*

/**
 * Test Specification for Prime
 */
class PrimeSpec extends Specification {

    @Shared
    /**
     * List of the first 26 prime numbers for use in testing
     */
    List first26 = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
                    47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101]


    def "Sanity check of environment"() {
        expect:
        true  // then the testing environment was properly setup
    }

    def "Sanity check main and code reporting"() {
        // :TODO - make a more meaningful main method validating arguments
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
        0  | 0  | [0]                         //zero to zero
        -1 | 0  | [-1, 0]                     //negative included
        -3 | 3  | [-3, -2, -1, 0, 1, 2, 3]    //negative to positive
        3  | 0  | [0, 1, 2, 3]                //inverse
        0  | -3 | [-3, -2, -1, 0]             //inverse negative
    }


    def "isPrime() - negatives, zero and 1 are not prime" (int val, boolean result) {
        Prime prime = new Prime()

        expect:
        result == prime.isPrime(val)

        where:
        val | result
        0   | false  // zero is not prime
        1   | false  // 1 is not prime
        -1  | false  // try a negative
        -2  | false  // try an even negative
        -3  | false  // 3 is in our algorithm, test it to verify nothing odd happening in the negative
        -4  | false  // test a bigger even negative
        -10 | false  // another bigger even negative
        -12 | false  // again
        -15 | false  // try an odd negative
    }

    def "isPrime() - 2 is the only even prime" () {
        Prime prime = new Prime()

        expect:
        prime.isPrime(2)

        [4,6,8,16,32,64,128,256,512,1024].each{
            assert !prime.isPrime(it)
        }
    }

    def "isPrime() - first 26 primes" () {
        Prime prime = new Prime()

        expect:
        first26.each {
            assert prime.isPrime(it)
        }
    }

    def "isPrime() - odd non primes" () {
        Prime prime = new Prime()

        expect:
        [9, 15, 21, 25, 27, 33, 35, 39, 45, 49, 51, 55, 57, 63, 65, 69, 75, 77, 81, 85, 87, 91, 93, 95, 99].each{
            assert !prime.isPrime(it)
        }

    }

    def "isPrime() - Some big primes" () {
        Prime prime = new Prime()

        expect:
        [8017, 104729, 67867967, 982451653].each{   // Pulling from a list of primes on the net:
                                                    // http://primes.utm.edu/lists/small/millions/
            long start = System.currentTimeMillis()
            assert prime.isPrime(it)
            long end = System.currentTimeMillis()
            assert !prime.isPrime(it+2)             // lets check the next odd, very likely its not prime,
                                                    // but it will still exercise our algorithm
            long duration = (end - start)
            assert duration < 10L  /* lets see if these take a reasonable amount of time -
                                        Oh, The fifty millionth prime processes in less than a millisecond?
                                        Initial guess of 5 seconds for a much smaller prime was way off. */

            println "Processed isPrime for $it in $duration milliseconds - $start -- $end"
        }
    }

    def "generate - put it all together" () {
        Prime prime = new Prime()

        expect:
        [2,3,5] == prime.generate(0, 6)
        first26 == prime.generate(0, 102)

    }

}
