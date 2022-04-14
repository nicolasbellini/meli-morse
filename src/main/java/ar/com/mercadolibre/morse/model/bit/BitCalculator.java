package ar.com.mercadolibre.morse.model.bit;

import ar.com.mercadolibre.morse.model.bit.secuence.Sequence;
import lombok.Getter;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class BitCalculator {

    @Getter
    private int maxDot;
    @Getter
    private int maxDash;

    private final BitContainer bitContainer;

    public BitCalculator(String morseBitCoded) {
        this.bitContainer = new BitContainer(morseBitCoded);
        maxDot = calculateDotMaxBitLength();
        maxDash =calculateMaxBetweenDashDot();
    }

    public int calculateDotMaxBitLength(){
        AtomicReference<Integer> total = new AtomicReference<>(0);
        bitContainer.pulseSequences.forEach(s -> total.set(total.get() + s.length()));
        return total.get() / bitContainer.pulseSequences.size() ;
    }

    public int calculateMaxBetweenDashDot() {
        AtomicReference<Integer> total = new AtomicReference<>(0);
        bitContainer.getPauseSequences().forEach(s -> total.set(total.get() + s.length()));
        return total.get() / bitContainer.pauseSequences.size() ;
    }

    public ArrayList<Sequence> getAllSecuences(){
        return bitContainer.getAllSequences();
    }
}

