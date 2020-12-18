package controllers;


import domain.Heuristics;

public class ProcessGeneSequenceInput {
    private final String sequencesInput;
    private final int numberOfSequences;
    private final Heuristics heuristic;

    public ProcessGeneSequenceInput(String numberOfSequences, String heuristic, String sequences){
        this.numberOfSequences = (numberOfSequences.equals("")) ? 0 : Integer.parseInt(numberOfSequences);
        this.heuristic = heuristic.equals("Difference") ? Heuristics.DIFFERENCE : Heuristics.SIMILARITY;
        this.sequencesInput = sequences;
    }

    public String getSequencesInput() {
        return sequencesInput;
    }

    public int getNumberOfSequences() {
        return numberOfSequences;
    }

    public Heuristics getHeuristic() {
        return heuristic;
    }
}
