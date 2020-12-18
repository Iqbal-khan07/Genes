package domain.services;

import domain.GeneSequence;

import java.util.List;

public class GeneSequenceNamer implements IGeneSequenceNamer {
    @Override
    public void attachIdentifiers(List<GeneSequence> sequences) {
        for(int i=1; i <= sequences.size(); i++){
            sequences.get(i-1).setIdentifier(getCharForNumber(i));
        }
    }

    private String getCharForNumber(int i) {
        return i > 0 && i < 27 ? String.valueOf((char)(i + 'A' - 1)) : null;
    }
}
