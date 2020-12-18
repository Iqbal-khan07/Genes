package infrastructure;

import domain.GeneSequence;
import domain.Heuristics;
import domain.SimilarSequencePair;

import java.util.List;

public interface IGeneSequenceAnalyzer {
    List<SimilarSequencePair> analyzeSimilarity(List<GeneSequence> sequences, Heuristics heuristic);
}
