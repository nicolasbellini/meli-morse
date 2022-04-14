package ar.com.mercadolibre.morse.controller;

import ar.com.mercadolibre.morse.exception.CharNotFoundException;
import ar.com.mercadolibre.morse.exception.PatternMatchingException;
import ar.com.mercadolibre.morse.service.MorseServiceImpl;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/translate")
public class MorseController {

    @Autowired
    private MorseServiceImpl morseServiceImpl;

    @PostMapping("/2human")
    @ResponseStatus(HttpStatus.OK)
    public String toText(@ApiParam(value = "Translate to human readable", required = true, example = ".... --- .-.. .-")
                             @RequestParam String morse) throws PatternMatchingException, CharNotFoundException {
        return morseServiceImpl.translateToHuman(morse);
    }

    @PostMapping("/2morse")
    @ResponseStatus(HttpStatus.OK)
    public String toMorse(@ApiParam(value = "Translate to human readable", required = true, example = "HOLA")
            @RequestParam String text) throws PatternMatchingException, CharNotFoundException {
        return morseServiceImpl.translateToMorse(text.toUpperCase(Locale.ROOT));
    }


}
