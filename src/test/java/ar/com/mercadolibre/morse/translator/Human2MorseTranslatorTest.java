package ar.com.mercadolibre.morse.translator;

import ar.com.mercadolibre.morse.exception.CharNotFoundException;
import ar.com.mercadolibre.morse.exception.PatternMatchingException;
import ar.com.mercadolibre.morse.model.translator.Human2MorseTranslator;
import ar.com.mercadolibre.morse.utils.TestEnviroment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Human2MorseTranslatorTest extends TestEnviroment {


    Human2MorseTranslator human2MorseTranslator = new Human2MorseTranslator();

    @Test
    @DisplayName("Translates human sentence to morse code")
    public void test1() throws PatternMatchingException, CharNotFoundException {
        String morse = human2MorseTranslator.translate(sentence);
        Assertions.assertEquals(morse1, morse);
    }

    @Test
    @DisplayName("Translating a word with invalid charaters should throw PatternMatchingException")
    public void test2() {
        Assertions.assertThrows(PatternMatchingException.class, () -> human2MorseTranslator.translate("&$%&$"));
    }
}
