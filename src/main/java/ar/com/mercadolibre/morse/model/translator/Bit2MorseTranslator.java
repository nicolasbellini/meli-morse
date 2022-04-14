package ar.com.mercadolibre.morse.model.translator;

import ar.com.mercadolibre.morse.model.bit.BitCalculator;
import ar.com.mercadolibre.morse.model.bit.secuence.Sequence;

public class Bit2MorseTranslator {

    BitCalculator bitCalculator;

    public String translateToMorse(String bits){
        String finalMorse = "";
        bitCalculator = new BitCalculator(bits);

        for (Sequence secuence : bitCalculator.getAllSecuences()) {
            finalMorse = finalMorse + translateSecuence(secuence);
        }
        return finalMorse;
    }

    private String translateSecuence(Sequence secuence) {
        return secuence.translate(bitCalculator);
    }

}
