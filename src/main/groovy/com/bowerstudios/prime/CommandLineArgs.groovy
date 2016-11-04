package com.bowerstudios.prime

import com.beust.jcommander.Parameter
import groovy.transform.CompileStatic

/**
 * Validator and Extractor for Command Line Arguments
 */
@CompileStatic
class CommandLineArgs {

    @Parameter (names=['--start', '-s'])
    int startVal
    @Parameter(names=['--end', '-e'])
    int endVal

}
