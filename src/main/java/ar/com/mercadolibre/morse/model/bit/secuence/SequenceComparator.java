package ar.com.mercadolibre.morse.model.bit.secuence;

import java.util.Comparator;

public class SequenceComparator implements Comparator<Sequence>{
    @Override
    public int compare(Sequence o1, Sequence o2) {
        return Integer.compare(o1.sequence.length(), o2.sequence.length());
    }
}
