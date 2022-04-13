package ar.com.mercadolibre.morse.model.translator;

import ar.com.mercadolibre.morse.MorseTable;
import ar.com.mercadolibre.morse.exception.CharNotFoundException;
import ar.com.mercadolibre.morse.exception.PatternMatchingException;

public class Morse2HumanTranslator extends MorseTranslator{
    public Morse2HumanTranslator() {
        super(MorseTable.getMorseToLetterMap());
    }

    public String translateToHuman(String morse) throws PatternMatchingException, CharNotFoundException {
        //this.checkValid(morse, "(-|\\.| )");
        String finalPhrase = "";
        String[] words = morse.trim().split("\\s\\s+");

        for (String word : words) {
            String finalWord = this.translateWord(word.trim().split("\\s+"), "");
            finalPhrase = finalPhrase + finalWord + " ";
        }
        return finalPhrase.trim();

    }

}
