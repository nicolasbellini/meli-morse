package ar.com.mercadolibre.morse.model;

import ar.com.mercadolibre.morse.exception.CharNotFoundException;
import org.apache.commons.collections4.BidiMap;

public abstract class MorseTranslator {

    BidiMap<String, String> charMap;

    public MorseTranslator(BidiMap<String, String> charMap) {
        this.charMap = charMap;
    }

    String translateWord(String[] word) throws CharNotFoundException {
        String translatedWord = "";
        for (String character : word) {
            translatedWord = translatedWord + translateCharacter(character);
        }
        return translatedWord;
    }

    String translateCharacter(String morseChar) throws CharNotFoundException {
        String translatedLetter = charMap.get(morseChar);
        if (translatedLetter == null){
            throw new CharNotFoundException("Could not find translation for: " + morseChar);
        }
        return translatedLetter;
    }

}
