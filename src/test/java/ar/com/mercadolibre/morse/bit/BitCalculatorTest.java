package ar.com.mercadolibre.morse.bit;

import ar.com.mercadolibre.morse.model.bit.BitCalculator;
import ar.com.mercadolibre.morse.utils.TestEnviroment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitCalculatorTest extends TestEnviroment{

    BitCalculator bitCalculator = new BitCalculator(morseBitCoded1);

    @Test
    public void testGetDotMaxBitLength(){
        int maxBitLenght = bitCalculator.calculateDotMaxBitLength();
        assertEquals(maxBitLenght, 4);
    }

    @Test
    public void testGetMaxBetweenDashDot(){
        int maxBitLenght = bitCalculator.calculateMaxBetweenDashDot();
        assertEquals(4 , maxBitLenght);
    }

}