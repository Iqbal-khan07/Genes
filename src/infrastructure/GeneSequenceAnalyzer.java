package infrastructure;

import domain.GeneSequence;
import domain.Heuristics;
import domain.SequenceBase;
import domain.SimilarSequencePair;

import java.util.LinkedList;
import java.util.List;

public class GeneSequenceAnalyzer implements IGeneSequenceAnalyzer {

    @Override
    public List<SimilarSequencePair> analyzeSimilarity(final List<GeneSequence> sequences, final Heuristics heuristic) {
        List<SimilarSequencePair> similarPairs = new LinkedList<>();


        for(int i=0; i < sequences.size(); i++){
            int maxScore = Integer.MIN_VALUE;
            int score;
            GeneSequence mostSimilar = null;


            for(int j=0; j < sequences.size(); j++){
                if(i != j){
                    if(heuristic == Heuristics.SIMILARITY){
                        score =getSimilarityScore(sequences.get(i), sequences.get(j), new ISequenceComparator() {
                            @Override
                            public boolean compare(SequenceBase b1, SequenceBase b2) {
                                return (b1.compareTo(b2) == 0);
                            }
                        });
                    } else {
                        score = getSimilarityScore(sequences.get(i), sequences.get(j), new ISequenceComparator() {
                            @Override
                            public boolean compare(SequenceBase b1, SequenceBase b2) {
                                return !(b1.compareTo(b2) == 0);
                            }
                        });
                    }

                    if(score >= maxScore){
                        if(mostSimilar != null && score == maxScore && heuristic == Heuristics.SIMILARITY){
                            mostSimilar = (sequences.get(i).getLength() == mostSimilar.getLength()) ? mostSimilar:sequences.get(j);
                        }else{
                            mostSimilar = sequences.get(j);
                        }
                        maxScore = score;
                    }
                }
            }


            similarPairs.add(new SimilarSequencePair(sequences.get(i), mostSimilar, maxScore));
        }

        return similarPairs;
    }

    private int getSimilarityScore(final GeneSequence s1, final GeneSequence s2, final ISequenceComparator comparator){
        int score = 0;

        int index = 0;
        while(index < s1.getLength() && index < s2.getLength()){
            if(comparator.compare(s1.getBase(index), s2.getBase(index))){
                score++;
            }
            index++;
        }

        int difference = Math.abs(s1.getLength() - s2.getLength());
        if(!comparator.compare(s1.getBase(0), s1.getBase(0))){
            score += difference;
        }

        return score;

    }
}
