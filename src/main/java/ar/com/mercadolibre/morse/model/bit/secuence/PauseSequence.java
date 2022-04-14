package ar.com.mercadolibre.morse.model.bit.secuence;

import ar.com.mercadolibre.morse.model.bit.BitCalculator;

public class PauseSequence extends Sequence{

    public PauseSequence(String sequence) {
        super(sequence);
    }

    @Override
    public String translate(BitCalculator bitCalculator) {
        if(sequence.length() > bitCalculator.getMaxDash()){
            return " ";
        }
        return "";
    }

}
