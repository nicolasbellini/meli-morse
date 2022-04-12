package ar.com.mercadolibre.morse;

import ar.com.mercadolibre.morse.exception.CharNotFoundException;
import ar.com.mercadolibre.morse.exception.PatternMatchingException;
import ar.com.mercadolibre.morse.model.Human2MorseTranslator;
import ar.com.mercadolibre.morse.model.Morse2HumanTranslator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryDecoderTest {

    String morseBitCoded1 = "0000000011011011001110000011111100011111100111111000000011101111111101110" +
            "1110000000110001111110000011111100111111000000011000011011111111011101110" +
            "0000011011100000000000";

    String morse1 = ".... --- .-.. .-  -- . .-.. ..";


    Morse2HumanTranslator morse2HumanTranslator = new Morse2HumanTranslator();
    Human2MorseTranslator human2MorseTranslator = new Human2MorseTranslator();

    @Test
    public void testTranslateMorseToHuman() throws PatternMatchingException, CharNotFoundException {
        String decodedMorse = morse2HumanTranslator.translateToHuman(morse1);
        Assertions.assertEquals("HOLA MELI", decodedMorse);
    }

    @Test
    public void testTranslateHumanToMorse() throws PatternMatchingException, CharNotFoundException {
       String morse = human2MorseTranslator.translateToMorse("HOLA MELI");
        Assertions.assertEquals(morse1, morse);
    }

    @Test
    public void testGetDotMaxBitLength(){

        int maxBitLenght = BitCalculator.getDotMaxBitLength(morseBitCoded1);

        Assertions.assertEquals(maxBitLenght, 3);

    }

}
