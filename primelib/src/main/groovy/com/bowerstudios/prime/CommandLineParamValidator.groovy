package com.bowerstudios.prime

import com.bowerstudios.prime.ui.CommandLineArgs

/**
 *
 */
interface CommandLineParamValidator {

    CommandLineArgs validateParams(String[] args)
}
