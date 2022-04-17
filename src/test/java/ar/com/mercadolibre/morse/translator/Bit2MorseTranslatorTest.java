package ar.com.mercadolibre.morse.translator;

import ar.com.mercadolibre.morse.exception.PatternMatchingException;
import ar.com.mercadolibre.morse.model.translator.Bit2MorseTranslator;
import ar.com.mercadolibre.morse.utils.TestEnviroment;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Bit2MorseTranslatorTest extends TestEnviroment {

    Bit2MorseTranslator morseTranslator = new Bit2MorseTranslator();

    String morseBitCoded2 = "0000000011011011001110000011111100011111100111111000000011101111111101110" +
            "1110000000110001111110000000011111100111111000000011000011011111111011101110" +
            "0000011011100000000000";

    String morse2 = ".... --- .-.. .- -- ..-.. ..";

    @Test
    @DisplayName("Should transform a bit secuence into a morse code")
    public void test1() throws PatternMatchingException {
        Assert.assertEquals(morse2, morseTranslator.translateToMorse(morseBitCoded2));

    }


}
