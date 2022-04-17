package ar.com.mercadolibre.morse.model.bit.secuence;

import ar.com.mercadolibre.morse.model.bit.BitCalculator;

public class PulseSequence extends Sequence{

    public PulseSequence(String sequence) {
        super(sequence);
    }

    @Override
    public String translate(BitCalculator bitCalculator) {
        if(sequence.length() >= bitCalculator.getMaxDot()){
            return "-";
        }
        return ".";
    }

}
