package ar.com.mercadolibre.morse.service;

import ar.com.mercadolibre.morse.exception.CharNotFoundException;
import ar.com.mercadolibre.morse.exception.PatternMatchingException;
import ar.com.mercadolibre.morse.model.translator.Bit2MorseTranslator;
import ar.com.mercadolibre.morse.model.translator.Human2MorseTranslator;
import ar.com.mercadolibre.morse.model.translator.Morse2HumanTranslator;
import org.springframework.stereotype.Service;

@Service
public class MorseServiceImpl implements MorseService {

    Morse2HumanTranslator morse2HumanTranslator = new Morse2HumanTranslator();
    Human2MorseTranslator human2MorseTranslator = new Human2MorseTranslator();
    Bit2MorseTranslator bit2MorseTranslator = new Bit2MorseTranslator();

    public String translateToHuman(String morse) throws PatternMatchingException, CharNotFoundException {
        return morse2HumanTranslator.translate(morse);
    }

    public String translateToMorse(String text) throws PatternMatchingException, CharNotFoundException {
        return human2MorseTranslator.translate(text);
    }

    @Override
    public String translateBitsToMorse(String bits) throws PatternMatchingException {
        return bit2MorseTranslator.translateToMorse(bits);
    }
}
