package ar.com.mercadolibre.morse;

import ar.com.mercadolibre.morse.exception.CharNotFoundException;
import ar.com.mercadolibre.morse.exception.PatternMatchingException;
import org.apache.commons.collections4.BidiMap;

public class MorseTranslatorOld {

    BidiMap<String, String> morseToCharMap;
    BidiMap<String, String> charToMorseMap;

    public MorseTranslatorOld() {
        this.charToMorseMap = MorseTable.getLetterToMorseMap();
        this.morseToCharMap = charToMorseMap.inverseBidiMap();
    }

    public String translateToMorse(String phrase) throws PatternMatchingException {
        this.checkValid(phrase, "^[a-zA-Z0-9 ]+$");
        String finalMorse = "";
        char[] splitStr = phrase.toCharArray();

        for (char c : splitStr) {
            finalMorse = finalMorse + charToMorseMap.get(Character.toString(c)) + " ";
        }

        return finalMorse.trim();
    }

    private void checkValid(String morse, String regex) throws PatternMatchingException {
        if (!morse.matches(regex)){
            throw new PatternMatchingException("Wrong pattern");
        };
    }

}
