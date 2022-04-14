package ar.com.mercadolibre.morse.model;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class BitCalculator {

    private final BitContainer bitContainer;

    public BitCalculator(String morseBitCoded) {
        this.bitContainer = new BitContainer(morseBitCoded);
    }

    public int getDotMaxBitLength(){
        AtomicReference<Integer> total = new AtomicReference<>(0);
        bitContainer.pulseSecuences.forEach(s -> total.set(total.get() + s.length()));
        return total.get() / bitContainer.pulseSecuences.size() ;
    }

    public ArrayList<String> getAllSecuences(){
        return bitContainer.getAllSecuences();
    }


    public int getMaxBetweenDashDot() {
        AtomicReference<Integer> total = new AtomicReference<>(0);
        bitContainer.getPauseSecuences().forEach(s -> total.set(total.get() + s.length()));
        return total.get() / bitContainer.pauseSecuences.size() ;
    }
}

