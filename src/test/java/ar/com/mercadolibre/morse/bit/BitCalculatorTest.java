package ar.com.mercadolibre.morse.bit;

import ar.com.mercadolibre.morse.exception.PatternMatchingException;
import ar.com.mercadolibre.morse.model.bit.BitCalculator;
import ar.com.mercadolibre.morse.utils.TestEnviroment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BitCalculatorTest extends TestEnviroment{

    BitCalculator bitCalculator = new BitCalculator(morseBitCoded1);

    public BitCalculatorTest() throws PatternMatchingException {
    }

    @Test
    public void testGetDotMaxBitLength(){
        int maxBitLenght = bitCalculator.calculateDotMaxBitLength();
        assertEquals(maxBitLenght, 5);
    }

    @Test
    public void testGetMaxBetweenDashDot(){
        int maxBitLenght = bitCalculator.calculateSpaceMaxBitLength();
        assertEquals(4 , maxBitLenght);
    }

}
