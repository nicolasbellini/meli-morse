package ar.com.mercadolibre.morse.service;

import ar.com.mercadolibre.morse.exception.CharNotFoundException;
import ar.com.mercadolibre.morse.exception.PatternMatchingException;

public interface MorseService {
    String translateToHuman(String morse) throws PatternMatchingException, CharNotFoundException;
    String translateToMorse(String text) throws PatternMatchingException, CharNotFoundException;
}
