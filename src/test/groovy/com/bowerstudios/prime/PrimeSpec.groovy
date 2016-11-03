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

    def "basic request to check a range"() {
        Prime prime = new Prime()

        expect:
        !prime.generate(0,0)

    }

    def "zero and 1 are not prime" () {
        Prime prime = new Prime()

        expect:
        !prime.isPrime(0)
        !prime.isPrime(1)
    }

}
