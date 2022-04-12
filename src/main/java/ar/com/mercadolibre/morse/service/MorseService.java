package ar.com.mercadolibre.morse.service;

import ar.com.mercadolibre.morse.MorseTranslatorOld;
import ar.com.mercadolibre.morse.exception.CharNotFoundException;
import ar.com.mercadolibre.morse.exception.PatternMatchingException;
import ar.com.mercadolibre.morse.model.Morse2HumanTranslator;
import org.springframework.stereotype.Service;

@Service
public class MorseService {

    Morse2HumanTranslator morse2HumanTranslator = new Morse2HumanTranslator();

    public String translateToHuman(String morse) throws PatternMatchingException, CharNotFoundException {
        return morse2HumanTranslator.translateToHuman(morse);
    }

    public String translateToMorse(String text) throws PatternMatchingException {
        return "morseTranslator.translateToMorse(text)";
    }
}
