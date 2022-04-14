package ar.com.mercadolibre.morse.model.bit.secuence;

import ar.com.mercadolibre.morse.model.bit.BitCalculator;

import java.util.Objects;

public abstract class Sequence {

    String sequence;

    public Sequence(String sequence) {
        this.sequence = sequence;
    }

    public abstract String translate(BitCalculator bitCalculator);

    public int length() {
        return sequence.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sequence)) return false;
        Sequence sequence1 = (Sequence) o;
        return Objects.equals(sequence, sequence1.sequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sequence);
    }
}
