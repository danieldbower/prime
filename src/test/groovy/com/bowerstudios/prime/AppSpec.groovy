package com.bowerstudios.prime

import spock.lang.*

/**
 * Test Specification for App
 */
class AppSpec extends Specification {

    def "Sanity check of environment"() {
        expect:
        new App()  // then the testing environment was properly setup
    }

    def "main - put it all together" () {
        expect:
        App.main(['-s', '0', '-e', '6'] as String[])
        App.main(['-s', '0', '-e', '102'] as String[])
        App.main(['--help'] as String[])
    }

}
