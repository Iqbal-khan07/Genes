package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeneSequence implements Iterable<SequenceBase> {
    private final List<SequenceBase> sequence;
    private String identifier;

    public GeneSequence(){
        this.sequence = new ArrayList<>();
    }

    public GeneSequence(String identifier){
        this.sequence = new ArrayList<>();
        this.identifier = identifier;
    }

    public int getLength() {
        return this.sequence.size();
    }

    public SequenceBase getBase(int index){
        return this.sequence.get(index);
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier){
        this.identifier = identifier;
    }

    public void addSequenceBase(String base) throws InvalidBaseException {
        this.sequence.add(SequenceBase.parseBase(base));
    }

    @Override
    public Iterator<SequenceBase> iterator() {
        return this.sequence.iterator();
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();

        for(SequenceBase base: sequence){
            output.append(String.format("%s | ", base.getBase().toString()));
        }

        return output.toString();
    }
}
