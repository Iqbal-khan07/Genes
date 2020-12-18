package domain;

public class SimilarSequencePair {
    private final GeneSequence sequence1;

    private final GeneSequence sequence2;
    private final int score;

    public SimilarSequencePair(GeneSequence s1, GeneSequence s2, int score){
        this.sequence1 = s1;
        this.sequence2 = s2;
        this.score = score;
    }

    public GeneSequence getSequence1() {
        return sequence1;
    }

    public GeneSequence getSequence2() {
        return sequence2;
    }

    public int getScore() {
        return score;
    }

}
