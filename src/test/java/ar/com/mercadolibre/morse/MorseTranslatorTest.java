package ar.com.mercadolibre.morse;

import ar.com.mercadolibre.morse.exception.CharNotFoundException;
import ar.com.mercadolibre.morse.exception.PatternMatchingException;
import ar.com.mercadolibre.morse.model.BitCalculator;
import ar.com.mercadolibre.morse.model.translator.Human2MorseTranslator;
import ar.com.mercadolibre.morse.model.translator.Morse2HumanTranslator;
import ar.com.mercadolibre.morse.utils.TestEnviroment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MorseTranslatorTest  extends TestEnviroment {

    Morse2HumanTranslator morse2HumanTranslator = new Morse2HumanTranslator();
    Human2MorseTranslator human2MorseTranslator = new Human2MorseTranslator();

    @Test
    @DisplayName("Translates morse code to human readable sentence")
    public void test1() throws PatternMatchingException, CharNotFoundException {
        String decodedMorse = morse2HumanTranslator.translateToHuman(morse1);
        Assertions.assertEquals(sentence, decodedMorse);
    }

    @Test
    @DisplayName("Translates human sentence to morse code")
    public void test2() throws PatternMatchingException, CharNotFoundException {
       String morse = human2MorseTranslator.translateToMorse(sentence);
        Assertions.assertEquals(morse1, morse);
    }


}
