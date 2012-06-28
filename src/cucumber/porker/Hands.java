package cucumber.porker;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Hands implements Iterable<Card> {
    private static final int SIZE = 5;
    private final Set<Card> hands = new HashSet<Card>(SIZE);
    public Hands(Card... cards) {
        if (cards.length != SIZE) 
            throw new IllegalArgumentException();
        for (Card card : cards) {
            hands.add(card);
        }
    }
    @Override
    public Iterator<Card> iterator() {
        return hands.iterator();
    }
}