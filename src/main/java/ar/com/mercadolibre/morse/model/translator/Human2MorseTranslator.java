package ar.com.mercadolibre.morse.model.translator;

import ar.com.mercadolibre.morse.MorseTable;
import ar.com.mercadolibre.morse.exception.CharNotFoundException;
import ar.com.mercadolibre.morse.exception.PatternMatchingException;

public class Human2MorseTranslator extends MorseTranslator{
    public Human2MorseTranslator() {
        super(MorseTable.getLetterToMorseMap());
    }

    public String translate(String phrase) throws PatternMatchingException, CharNotFoundException {
        this.checkValid(phrase, "^[a-zA-Z0-9 ]+$");
        String finalMorse = "";
        String[] words = phrase.split("\\s+");

        for (String word : words) {
            String finalWord = this.translateWord(word.split(""), " ");
            finalMorse = finalMorse + finalWord + " ";
        }
        return finalMorse.trim();
    }

}
