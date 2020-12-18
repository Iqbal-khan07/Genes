package domain;

import java.util.Arrays;
import java.util.HashSet;

public class SequenceBase implements Comparable<SequenceBase> {
    private final Bases base;

    public enum Bases {
        A, T, G, C
    }

    public static SequenceBase parseBase(String s) throws InvalidBaseException {
        final HashSet<String> valid = new HashSet<>(Arrays.asList("A", "T", "G", "C"));
        if(!valid.contains(s.toUpperCase())){
            throw new InvalidBaseException(String.format("Invalid base <%s> provided", s));
        }

        return new SequenceBase(Bases.valueOf(s.toUpperCase()));
    }

    public SequenceBase(final Bases base) {
        this.base = base;
    }

    public Bases getBase(){
        return this.base;
    }

    @Override
    public int compareTo(SequenceBase o) {
        return this.base.compareTo(o.base);
    }

    @Override
    public String toString() {
        return String.format("<SequenceBase> %s ", this.base.toString());
    }

}