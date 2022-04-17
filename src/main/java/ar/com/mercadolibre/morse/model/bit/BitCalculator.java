package ar.com.mercadolibre.morse.model.bit;

import ar.com.mercadolibre.morse.exception.PatternMatchingException;
import ar.com.mercadolibre.morse.model.bit.secuence.Sequence;
import lombok.Getter;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class BitCalculator {

    @Getter
    private int maxDot;
    @Getter
    private int minSpace;

    private final BitContainer bitContainer;

    public BitCalculator(String morseBitCoded) throws PatternMatchingException {
        this.bitContainer = new BitContainer(morseBitCoded);
        maxDot = calculateDotMaxBitLength();
        minSpace = calculateSpaceMaxBitLength();
    }

    public int calculateDotMaxBitLength(){
        AtomicReference<Integer> total = new AtomicReference<>(0);
        bitContainer.pulseSequences.forEach(s -> total.set(total.get() + s.length()));
        return (int) Math.ceil((double) total.get() / bitContainer.pulseSequences.size());
    }

    public int calculateSpaceMaxBitLength() {
        AtomicReference<Integer> total = new AtomicReference<>(0);
        bitContainer.getPauseSequences().forEach(s -> total.set(total.get() + s.length()));
        return (int) Math.ceil((double) total.get() / bitContainer.pauseSequences.size());
    }

    public ArrayList<Sequence> getAllSequences(){
        return bitContainer.getAllSequences();
    }
}

