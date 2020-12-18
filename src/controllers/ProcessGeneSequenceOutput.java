package controllers;

import controllers.viewport.IViewPort;
import domain.GeneSequence;
import domain.Heuristics;
import domain.SimilarSequencePair;

import java.util.List;


public class ProcessGeneSequenceOutput implements IViewPort {
    private final String sequences;
    private final String similarPairs;
    private final String heuristic;

    public ProcessGeneSequenceOutput(List<GeneSequence> sequences, List<SimilarSequencePair> pairs, Heuristics heuristic){
        this.heuristic = heuristic.toString();
        StringBuilder sequenceViewModel = new StringBuilder();

        for(GeneSequence s: sequences){
            sequenceViewModel.append(String.format("%s => ", s.getIdentifier()));
            for(int i=0 ; i<s.getLength(); i++){
                sequenceViewModel.append(s.getBase(i).getBase());
            }
            sequenceViewModel.append('\n');
        }

        this.sequences = sequenceViewModel.toString();

        StringBuilder pairViewModel = new StringBuilder();
        for(SimilarSequencePair pair: pairs){
            String heuristicString = heuristic == Heuristics.SIMILARITY ? "similar":"different";
            String heuristicString2 = heuristic == Heuristics.SIMILARITY ? "similarities":"differences";
            pairViewModel.append(String.format(
                        "%s is most %s to %s : Number of %s are %d \n",
                        pair.getSequence1().getIdentifier(),
                        heuristicString,
                        pair.getSequence2().getIdentifier(),
                        heuristicString2,
                        pair.getScore()
                    )
            );
        }
        pairViewModel.append('\n');

        this.similarPairs = pairViewModel.toString();
    }



    public String getSequencesViewModel(){
        return sequences;
    }

    public String getPairsViewModel(){
        return this.similarPairs;
    }

    public String getHeuristic(){
        return this.heuristic;
    }

}
