package com.bowerstudios.prime

import com.bowerstudios.prime.inspectorImpl.SingleThreadNumberInspector
import spock.lang.Shared
import spock.lang.Specification

/**
 * Test Specification for Number Inspector
 */
class NumberInspectorSpec extends Specification {

    /**
     * List of the first 26 prime numbers for use in testing
     */
    static List first26 = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
                    47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101]

    @Shared
    NumberInspector numberInspector = new SingleThreadNumberInspector()

    def "negatives, zero and 1 are not prime" (int val, boolean result) {
        expect:
        result == numberInspector.isPrime(val)

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

    def "2 is the only even prime" () {
        expect:
        numberInspector.isPrime(2)

        [4,6,8,16,32,64,128,256,512,1024].each{
            assert !numberInspector.isPrime(it)
        }
    }

    def "first 26 primes" () {
        expect:
        first26.each {
            assert numberInspector.isPrime(it)
        }
    }

    def "odd non primes" () {
        expect:
        [9, 15, 21, 25, 27, 33, 35, 39, 45, 49, 51, 55, 57, 63, 65, 69, 75, 77, 81, 85, 87, 91, 93, 95, 99].each{
            assert !numberInspector.isPrime(it)
        }

    }

    def "Some big primes" () {
        expect:
        [8017, 104729, 67867967, 982451653].each{   // Pulling from a list of primes on the net:
                                                    // http://primes.utm.edu/lists/small/millions/
            long start = System.currentTimeMillis()
            assert numberInspector.isPrime(it)
            long end = System.currentTimeMillis()
            assert !numberInspector.isPrime(it+2)             // lets check the next odd, very likely its not prime,
                                                    // but it will still exercise our algorithm
            long duration = (end - start)
            assert duration < 10L  /* lets see if these take a reasonable amount of time -
                                        Oh, The fifty millionth prime processes in less than a millisecond?
                                        Initial guess of 5 seconds for a much smaller prime was way off. */

            println "Processed isPrime for $it in $duration milliseconds - $start -- $end"
        }
    }
}
