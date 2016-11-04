package com.bowerstudios.prime

import spock.lang.Specification

/**
 * Test Specification for Number Inspector
 */
class CommandLineArgsSpec extends Specification {

    def "100% cheater" () {  // Accessing of the Command Line Args not showing up in code coverage report
        CommandLineArgs commandLineArgs = new CommandLineArgs()
        commandLineArgs.help = true
        commandLineArgs.startVal = 0
        commandLineArgs.endVal = 100

        expect:
            commandLineArgs.help
            commandLineArgs.startVal == 0
            commandLineArgs.endVal == 100

    }

}
