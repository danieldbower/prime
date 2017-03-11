package com.bowerstudios.prime

import com.bowerstudios.prime.generatorImpl.PrimeNumberGeneratorRanged
import com.bowerstudios.prime.inspectorImpl.SingleThreadNumberInspector
import spock.lang.Shared
import spock.lang.Specification

/**
 * Test Specification for PrimeNumberGeneratorRanged
 */
class PrimeNumberGeneratorRangedSpec extends Specification {

    @Shared
    //Strongly typing the reference so we can access functions outside of the interface
    PrimeNumberGeneratorRanged primeNumberGenerator = create()

    def "generate - put it all together" (int fromVal, int toVal, List result) {
        expect:
        result == primeNumberGenerator.generate(fromVal, toVal)

        where:
        fromVal | toVal | result
           0 |    6 | [2,3,5]                         // simple example
           0 |  102 | NumberInspectorSpec.first26     // first 26
        7900 | 7920 | [7901, 7907, 7919]              // required example
    }

    def "create an ordered range"(int fromVal, int toVal, List result) {
        expect:
        result == primeNumberGenerator.createRangeFrom(fromVal,toVal)

        where:
        fromVal | toVal | result
        0  | 0  | [0]                         //zero to zero
        -1 | 0  | [-1, 0]                     //negative included
        -3 | 3  | [-3, -2, -1, 0, 1, 2, 3]    //negative to positive
        3  | 0  | [0, 1, 2, 3]                //inverse
        0  | -3 | [-3, -2, -1, 0]             //inverse negative
    }

    PrimeNumberGeneratorRanged create(){
        new PrimeNumberGeneratorRanged(
                numberInspector: new SingleThreadNumberInspector()
        )
    }
}
