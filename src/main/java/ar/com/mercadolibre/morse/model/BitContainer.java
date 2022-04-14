package ar.com.mercadolibre.morse.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitContainer {

    @Getter
    ArrayList<String> allSecuences = new ArrayList<>();
    @Getter
    Set<String> pulseSecuences = new TreeSet<>();
    @Getter
    Set<String> pauseSecuences = new TreeSet<>();

    public BitContainer(String morseBitCoded) {
        this.mapSecuences(removeStatic(morseBitCoded));
    }

    public BitContainer() {

    }

    private String removeStatic(String morseBitCoded) {
        return morseBitCoded.substring(morseBitCoded.indexOf("1"), morseBitCoded.lastIndexOf("1") + 1);
    }

    private void mapSecuences(String morseBitCoded) {
        final Matcher matcher = Pattern.compile("1+|0+").matcher(morseBitCoded);
        matcher.results().forEach(matchResult -> mapSecuence(matchResult.group()));
    }

    private void mapSecuence(String secuence) {
        allSecuences.add(secuence);
        if(secuence.matches("0+")){
            pauseSecuences.add(secuence);
        }
        else{
            pulseSecuences.add(secuence);
        }
    }


}
