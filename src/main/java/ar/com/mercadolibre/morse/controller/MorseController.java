package ar.com.mercadolibre.morse.controller;

import ar.com.mercadolibre.morse.exception.CharNotFoundException;
import ar.com.mercadolibre.morse.exception.PatternMatchingException;
import ar.com.mercadolibre.morse.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/translate")
public class MorseController {

    @Autowired
    private MorseService morseService;

    @PostMapping("/2human")
    @ResponseStatus(HttpStatus.OK)
    public String toText(@RequestBody String morse) throws PatternMatchingException, CharNotFoundException {
        return morseService.translateToHuman(morse);
    }

    @PostMapping("/2morse")
    @ResponseStatus(HttpStatus.OK)
    public String toMorse(@RequestBody String text) throws PatternMatchingException, CharNotFoundException {
        return morseService.translateToMorse(text);
    }


}
