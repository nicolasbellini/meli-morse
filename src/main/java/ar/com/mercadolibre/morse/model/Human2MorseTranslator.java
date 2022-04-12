package ar.com.mercadolibre.morse.model;

import ar.com.mercadolibre.morse.MorseTable;
import ar.com.mercadolibre.morse.exception.CharNotFoundException;
import ar.com.mercadolibre.morse.exception.PatternMatchingException;

public class Human2MorseTranslator extends MorseTranslator{
    public Human2MorseTranslator() {
        super(MorseTable.getMorseToLetterMap());
    }

    public String translateToMorse(String phrase) throws PatternMatchingException, CharNotFoundException {
        this.checkValid(phrase, "^[a-zA-Z0-9 ]+$");
        String finalMorse = "";
        String[] words = phrase.split("\\s+");

        for (String word : words) {
            String finalWord = this.translateWord(word.split(""));
            finalMorse = finalMorse + finalWord + " ";
        }

        return finalMorse.trim();
    }

    private void checkValid(String morse, String regex) throws PatternMatchingException {
        if (!morse.matches(regex)){
            throw new PatternMatchingException("Wrong pattern");
        };
    }

}
