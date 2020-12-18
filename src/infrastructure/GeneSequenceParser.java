package infrastructure;

import domain.GeneSequence;
import domain.InvalidBaseException;

import java.util.LinkedList;
import java.util.List;

public class GeneSequenceParser implements IGeneSequenceParser {

    @Override
    public List<GeneSequence> parse(String input) throws InvalidBaseException {
        List<GeneSequence> output = new LinkedList<>();
        String[] rawSequences = input.strip().split("\n");
        for(String rawSequence: rawSequences){
            output.add(this.parseGeneSequence(rawSequence));
        }

        return output;
    }

    private GeneSequence parseGeneSequence(String s) throws InvalidBaseException {
        GeneSequence sequence = new GeneSequence();
        for(char b: s.toCharArray()){
            sequence.addSequenceBase(String.valueOf(b));
        }
        return sequence;
    }
}
