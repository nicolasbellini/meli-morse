package ar.com.mercadolibre.morse;

import ar.com.mercadolibre.morse.model.bit.BitContainer;
import ar.com.mercadolibre.morse.model.bit.secuence.PauseSequence;
import ar.com.mercadolibre.morse.model.bit.secuence.PulseSequence;
import ar.com.mercadolibre.morse.utils.TestEnviroment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class BitContainerTest extends TestEnviroment {

    BitContainer bitContainer;

    @BeforeEach
    public void beforeEach(){
        bitContainer = new BitContainer();
    }

    @Test
    @DisplayName("Should map all secuences of a bit string")
    public void test1(){
        BitContainer bitContainer = new BitContainer(morseBitCoded1);
        Assertions.assertEquals(bitContainer.getAllSequences().size(), 43);
    }

    @Test
    @DisplayName("Should remove first and last secuences of 0")
    public void test2(){
        String finalBits = "11011011001110000011111100011111100111111000000011101111111101110" +
                "1110000000110001111110000011111100111111000000011000011011111111011101110" +
                "00000110111";
        Assertions.assertEquals(ReflectionTestUtils.invokeMethod(bitContainer, "removeStatic", morseBitCoded1),finalBits);
    }

    @Test
    @DisplayName("Should add a 1 or 0 secuence to the correct map")
    public void test3(){
        ReflectionTestUtils.invokeMethod(bitContainer, "mapSecuence", "00");
        ReflectionTestUtils.invokeMethod(bitContainer, "mapSecuence", "11");
        Assertions.assertTrue(bitContainer.getPulseSequences().contains(new PulseSequence("11")));
        Assertions.assertTrue(bitContainer.getPauseSequences().contains(new PauseSequence("00")));
    }

}
