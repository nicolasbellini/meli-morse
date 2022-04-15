package ar.com.mercadolibre.morse.translator;

import ar.com.mercadolibre.morse.exception.CharNotFoundException;
import ar.com.mercadolibre.morse.exception.PatternMatchingException;
import ar.com.mercadolibre.morse.model.translator.Human2MorseTranslator;
import ar.com.mercadolibre.morse.model.translator.Morse2HumanTranslator;
import ar.com.mercadolibre.morse.utils.TestEnviroment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.lang.reflect.UndeclaredThrowableException;

public class MorseTranslatorTest  extends TestEnviroment {

    Morse2HumanTranslator morse2HumanTranslator = new Morse2HumanTranslator();
    Human2MorseTranslator human2MorseTranslator = new Human2MorseTranslator();

    @Test
    @DisplayName("Translates morse code to human readable sentence")
    public void test1() throws PatternMatchingException, CharNotFoundException {
        String decodedMorse = morse2HumanTranslator.translate(morse1);
        Assertions.assertEquals(sentence, decodedMorse);
    }

    @Test
    @DisplayName("Translates human sentence to morse code")
    public void test2() throws PatternMatchingException, CharNotFoundException {
       String morse = human2MorseTranslator.translate(sentence);
        Assertions.assertEquals(morse1, morse);
    }

    @Test
    @DisplayName("Should translate one morse character")
    public void test3(){
        Assertions.assertEquals(ReflectionTestUtils.invokeMethod(morse2HumanTranslator, "translateCharacter", ".-"),"A");
    }

    @Test
    @DisplayName("Should throw CharNotFoundException when trying to translate an unknown secuence")
    public void test4(){
        try {
            ReflectionTestUtils.invokeMethod(morse2HumanTranslator, "translateCharacter", "A");
        }catch (UndeclaredThrowableException exception){
            Assertions.assertTrue(exception.getCause().getClass().equals(CharNotFoundException.class));
        }
    }

    @Test
    @DisplayName("Should translate one morse word")
    public void test5(){
        String[] word = new String[4];word[0] = "....";word[1] = "---";word[2] = ".-..";word[3] = ".-";
        Assertions.assertEquals(ReflectionTestUtils.invokeMethod(morse2HumanTranslator, "translateWord", word, ""),"HOLA");
    }


}
