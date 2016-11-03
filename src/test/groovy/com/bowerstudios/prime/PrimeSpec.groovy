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

}
