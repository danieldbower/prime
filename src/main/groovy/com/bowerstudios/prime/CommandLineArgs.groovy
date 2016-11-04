package com.bowerstudios.prime

import com.beust.jcommander.Parameter
import groovy.transform.CompileStatic

/**
 * Validator and Extractor for Command Line Arguments
 */
@CompileStatic
class CommandLineArgs {

    @Parameter (names=['--start', '-s'], description = 'The integer to start the range', required = true)
    int startVal
    @Parameter(names=['--end', '-e'], description = 'The integer to end the range', required = true)
    int endVal

    @Parameter(names = '--help', help = true)
    boolean help = false

}
