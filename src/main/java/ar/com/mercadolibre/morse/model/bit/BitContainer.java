package ar.com.mercadolibre.morse.model.bit;

import ar.com.mercadolibre.morse.model.bit.secuence.PauseSequence;
import ar.com.mercadolibre.morse.model.bit.secuence.PulseSequence;
import ar.com.mercadolibre.morse.model.bit.secuence.Sequence;
import ar.com.mercadolibre.morse.model.bit.secuence.SequenceComparator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BitContainer {

    @Getter
    ArrayList<Sequence> allSequences = new ArrayList<>();
    @Getter
    Set<Sequence> pulseSequences = new TreeSet<>(new SequenceComparator());
    @Getter
    Set<Sequence> pauseSequences = new TreeSet<>(new SequenceComparator());

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

    private void mapSecuence(String bitsequence) {
        Sequence sequence;
        if(bitsequence.matches("0+")){
            sequence = new PauseSequence(bitsequence);
            pauseSequences.add(sequence);
        }
        else{
            sequence = new PulseSequence(bitsequence);
            pulseSequences.add(sequence);
        }
        allSequences.add(sequence);
    }


}
