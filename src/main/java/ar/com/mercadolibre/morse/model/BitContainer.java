package ar.com.mercadolibre.morse.model;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitContainer {

    ArrayList<String> allSecuences = new ArrayList<>();
    Set<String> dotsSecuences = new TreeSet<>();
    Set<String> dashSecuences = new TreeSet<>();

    public BitContainer(String morseBitCoded) {
        this.mapSecuences(morseBitCoded);
    }

    private void mapSecuences(String morseBitCoded) {
        final Matcher matcher = Pattern.compile("1+|0+").matcher(morseBitCoded);

        while (matcher.find()){
            matcher.results().forEach(matchResult -> mapSecuence(matchResult.group()));
        }
    }

    private void mapSecuence(String secuence) {
        allSecuences.add(secuence);
        if(secuence.matches("0+")){
            dashSecuences.add(secuence);
        }
        else{
            dotsSecuences.add(secuence);
        }
    }


}
