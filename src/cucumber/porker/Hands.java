package cucumber.porker;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Hands implements Iterable<Card> {
    private static final int SIZE = 5;
    private final Set<Card> hands = new HashSet<Card>(SIZE);
    public Hands(Card... cards) {
        if (!isCorrectCardsNumber(cards.length))
            throw new IllegalArgumentException();
        for (Card card : cards) {
            hands.add(card);
        }
    }
    // 不正なカード枚数
    private boolean isCorrectCardsNumber(int cardNumber) {
    	if(cardNumber != SIZE)
    		return false;
    	return true;
    }
    @Override
    public Iterator<Card> iterator() {
        return hands.iterator();
    }
}