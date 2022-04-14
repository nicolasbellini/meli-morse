package ar.com.mercadolibre.morse;

import ar.com.mercadolibre.morse.model.BitCalculator;
import ar.com.mercadolibre.morse.utils.TestEnviroment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitCalculatorTest extends TestEnviroment{

    @Test
    public void testGetDotMaxBitLength(){

        BitCalculator bitCalculator = new BitCalculator(morseBitCoded1);

        int maxBitLenght = bitCalculator.getDotMaxBitLength();

        assertEquals(maxBitLenght, 3);

    }


}
