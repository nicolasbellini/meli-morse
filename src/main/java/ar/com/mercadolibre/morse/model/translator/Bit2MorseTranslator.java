package ar.com.mercadolibre.morse.model.translator;

import ar.com.mercadolibre.morse.model.bit.BitCalculator;

public class Bit2MorseTranslator {

    BitCalculator bitCalculator;

    public String translateToMorse(String bits){
        String finalMorse = "";
        bitCalculator = new BitCalculator(bits);

        for (String secuence : bitCalculator.getAllSecuences()) {
            finalMorse = finalMorse + translateSecuence(secuence);
        }
        return finalMorse;
    }

    private String translateSecuence(String secuence) {
        if (secuence.contains("1")){
            return translatePulse(secuence, bitCalculator.getDotMaxBitLength());
        }
        else{
            return translatePause(secuence, bitCalculator.getMaxBetweenDashDot());
        }
    }

    private String translatePulse(String secuence, int dotMaxBitLength) {
        if(secuence.length() > dotMaxBitLength){
            return "-";
        }
        return ".";
    }

    private String translatePause(String secuence, int maxInbetweenDashDot) {
        if(secuence.length() > maxInbetweenDashDot){
            return " ";
        }
        return "";
    }

}
