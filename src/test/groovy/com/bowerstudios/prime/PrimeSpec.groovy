package com.bowerstudios.prime

import spock.lang.*

/**
 * Test Specification for Prime
 */
class PrimeSpec extends Specification {

    def "Sanity check of environment"() {
        expect:
        new Prime()  // then the testing environment was properly setup
    }

    def "main - put it all together" () {
        expect:
        Prime.main(['-s', '0', '-e', '6'] as String[])
        Prime.main(['-s', '0', '-e', '102'] as String[])
    }

}
