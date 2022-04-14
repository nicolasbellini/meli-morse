package ar.com.mercadolibre.morse;

import ar.com.mercadolibre.morse.model.bit.BitCalculator;
import ar.com.mercadolibre.morse.utils.TestEnviroment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitCalculatorTest extends TestEnviroment{

    BitCalculator bitCalculator = new BitCalculator(morseBitCoded1);

    @Test
    public void testGetDotMaxBitLength(){
        int maxBitLenght = bitCalculator.getDotMaxBitLength();
        assertEquals(maxBitLenght, 4);
    }

    @Test
    public void testGetMaxBetweenDashDot(){
        int maxBitLenght = bitCalculator.getMaxBetweenDashDot();
        assertEquals(4 , maxBitLenght);
    }

}
