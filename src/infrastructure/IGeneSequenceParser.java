package infrastructure;

import domain.GeneSequence;
import domain.InvalidBaseException;

import java.util.List;

public interface IGeneSequenceParser {
    List<GeneSequence> parse (String input) throws InvalidBaseException;
}
