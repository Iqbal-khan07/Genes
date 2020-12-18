package controllers;

import controllers.viewport.IViewPort;
import domain.GeneSequence;
import domain.InvalidBaseException;
import domain.SimilarSequencePair;
import domain.services.GeneSequenceNamer;
import domain.services.IGeneSequenceNamer;
import infrastructure.GeneSequenceAnalyzer;
import infrastructure.GeneSequenceParser;
import infrastructure.IGeneSequenceAnalyzer;
import infrastructure.IGeneSequenceParser;

import java.util.List;

public class ProcessGeneSequenceController implements IProcessGeneSequenceController {
    private final IGeneSequenceParser parser;
    private final IGeneSequenceAnalyzer analyzer;
    private final IGeneSequenceNamer namer;

    public ProcessGeneSequenceController(){
        parser = new GeneSequenceParser();
        analyzer = new GeneSequenceAnalyzer();
        namer = new GeneSequenceNamer();
    }

    public IViewPort execute(ProcessGeneSequenceInput input) {
        try {
            List<GeneSequence> sequences = parser.parse(input.getSequencesInput());
            namer.attachIdentifiers(sequences);

            if(sequences.size() != input.getNumberOfSequences()){
                return new ProcessGeneSequenceErrorOutput("Input the same number of sequences as indicated in the Field");
            }

            List<SimilarSequencePair> similarSequencePairs = analyzer.analyzeSimilarity(sequences, input.getHeuristic());

            return new ProcessGeneSequenceOutput(sequences, similarSequencePairs, input.getHeuristic());

        } catch (InvalidBaseException e) {
            return new ProcessGeneSequenceErrorOutput("Invalid Sequences Added: there is a invalid base in one of the sequences");
        }
    }
}
