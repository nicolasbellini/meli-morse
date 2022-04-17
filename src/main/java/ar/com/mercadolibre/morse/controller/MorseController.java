package ar.com.mercadolibre.morse.controller;

import ar.com.mercadolibre.morse.exception.CharNotFoundException;
import ar.com.mercadolibre.morse.exception.PatternMatchingException;
import ar.com.mercadolibre.morse.service.MorseServiceImpl;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Locale;

@RestController
@RequestMapping("/translate")
public class MorseController {

    @Autowired
    private MorseServiceImpl morseServiceImpl;

    @PostMapping("/2human")
    @ResponseStatus(HttpStatus.OK)
    public String toText(@ApiParam(value = "Translate to human readable", required = true, example = ".... --- .-.. .-")
                             @RequestParam String morse) {
        try{
            return morseServiceImpl.translateToHuman(morse);
        }catch (Exception | PatternMatchingException | CharNotFoundException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/2morse")
    public String toMorse(@ApiParam(value = "Translate to human readable", required = true, example = "HOLA")
            @RequestParam String text) {
        try{
            return morseServiceImpl.translateToMorse(text.toUpperCase(Locale.ROOT));
        }catch (Exception | PatternMatchingException | CharNotFoundException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getCause());
        }
    }

    @PostMapping("/bits2Morse")
    @ResponseStatus(HttpStatus.OK)
    public String bitsToMorse(@ApiParam (value = "Translate bits to morse code", required = true, example = "")
                              @RequestParam String bits) {
        try{
            return morseServiceImpl.translateBitsToMorse(bits);
        }catch (Exception | PatternMatchingException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


}
