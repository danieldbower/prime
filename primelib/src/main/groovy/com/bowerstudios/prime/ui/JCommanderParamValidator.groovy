package com.bowerstudios.prime.ui

import com.beust.jcommander.JCommander
import com.bowerstudios.prime.CommandLineParamValidator

/**
 * Validate Command Line Arguments with JCommander
 */
class JCommanderParamValidator implements CommandLineParamValidator {

    CommandLineArgs validateParams(String[] args){
        CommandLineArgs commandLineArgs = new CommandLineArgs()
        JCommander jCommander = new JCommander(commandLineArgs, args)  //with side effects!

        jCommander.setProgramName('App Number Generator')
        if (commandLineArgs.help) {
            jCommander.usage()
            return null
        }

        return commandLineArgs
    }
}
