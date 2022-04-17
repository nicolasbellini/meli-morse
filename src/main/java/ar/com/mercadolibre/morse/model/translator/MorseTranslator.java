package ar.com.mercadolibre.morse.model.translator;

import ar.com.mercadolibre.morse.exception.CharNotFoundException;
import ar.com.mercadolibre.morse.exception.PatternMatchingException;
import com.google.common.collect.BiMap;

public abstract class MorseTranslator {

    BiMap<String, String> charMap;

    public MorseTranslator(BiMap<String, String> charMap) {
        this.charMap = charMap;
    }

    public abstract String translate(String phrase) throws PatternMatchingException, CharNotFoundException;

    String translateWord(String[] word, String separator) throws CharNotFoundException {
        String translatedWord = "";
        for (String character : word) {
            translatedWord = translatedWord + translateCharacter(character) + separator;
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

    void checkValid(String morse, String regex) throws PatternMatchingException {
        if (!morse.matches(regex)){
            throw new PatternMatchingException("Illegal characters in string");
        };
    }


}
