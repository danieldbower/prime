package com.bowerstudios.prime

import groovy.transform.CompileStatic
import com.beust.jcommander.JCommander

/**
 * Driver for Exercise that will pull command line arguments and push them to the
 * PrimeNumberGenerator api
 */
@CompileStatic
class Prime {

    /**
     * We accept a --start and a --end, as command line parameters both must be present
     */
    static void main(String[] args) {
        // read and validate command line parameters
        CommandLineArgs commandLineArgs = new CommandLineArgs()
        new JCommander(commandLineArgs, args)  //with side effects!

        PrimeNumberGenerator primeNumberGenerator = new PrimeNumberGeneratorRanged()

        List<Integer> result = primeNumberGenerator.generate(
                commandLineArgs.startVal, commandLineArgs.endVal)

        println('Prime numbers: ' + result.join(','))
    }

}
