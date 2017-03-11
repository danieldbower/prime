package com.bowerstudios.prime

import com.bowerstudios.prime.generatorImpl.PrimeNumberGeneratorRanged
import com.bowerstudios.prime.inspectorImpl.SingleThreadNumberInspector
import com.bowerstudios.prime.ui.CommandLineArgs
import com.bowerstudios.prime.ui.JCommanderParamValidator
import groovy.transform.CompileStatic

/**
 * Driver for Exercise that will pull command line arguments and push them to the
 * PrimeNumberGenerator api
 */
@CompileStatic
class App {

    /**
     * We accept a --start and a --end, as command line parameters both must be present
     */
    static void main(String[] args) {
        CommandLineParamValidator commandLineParamValidator = new JCommanderParamValidator()

        PrimeNumberGenerator primeNumberGenerator = new PrimeNumberGeneratorRanged()
        primeNumberGenerator.setNumberInspector(new SingleThreadNumberInspector())

        App app = new App(commandLineParamValidator:commandLineParamValidator,
                primeNumberGenerator:primeNumberGenerator)

        app.run(args)

    }

    CommandLineParamValidator commandLineParamValidator
    PrimeNumberGenerator primeNumberGenerator

    void run(String[] args){
        CommandLineArgs commandLineArgs = commandLineParamValidator.validateParams(args)
        if(!commandLineArgs){
            return
        }

        List<Integer> result = primeNumberGenerator.generate(
                commandLineArgs.startVal, commandLineArgs.endVal)

        println('App numbers: ' + result.join(','))
    }

}
