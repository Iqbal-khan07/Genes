package infrastructure;

import domain.SequenceBase;

public interface ISequenceComparator {
    boolean compare(SequenceBase b1, SequenceBase b2);
}
