package domain.services;

import domain.GeneSequence;

import java.util.List;

public interface IGeneSequenceNamer {
    void attachIdentifiers(List<GeneSequence> sequences);
}

