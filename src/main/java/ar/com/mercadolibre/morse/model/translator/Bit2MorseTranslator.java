package ar.com.mercadolibre.morse.model.translator;

import ar.com.mercadolibre.morse.exception.PatternMatchingException;
import ar.com.mercadolibre.morse.model.bit.BitCalculator;
import ar.com.mercadolibre.morse.model.bit.secuence.Sequence;

public class Bit2MorseTranslator {

    BitCalculator bitCalculator;

    public String translateToMorse(String bits) throws PatternMatchingException {
        String finalMorse = "";
        bitCalculator = new BitCalculator(bits);

        for (Sequence secuence : bitCalculator.getAllSequences()) {
            finalMorse = finalMorse + translateSecuence(secuence);
        }
        return finalMorse;
    }

    private String translateSecuence(Sequence sequence) {
        return sequence.translate(bitCalculator);
    }

}
