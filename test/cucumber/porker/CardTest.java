package cucumber.porker;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CardTest {

	@Test
	public void testGetWithJUnit3() {
		Card actual = Card.get('H', 13);
		Card expected = new Card(Card.Suit.HEARTS, 13);
		assertEquals(actual.suit, expected.suit);
		assertEquals(actual.no, expected.no);
	}

	@Test
	public void testGet() {
		Card actual = Card.get('D', 1);
		Card expected = new Card(Card.Suit.DIAMONDS, 1);
		assertThat(actual.suit, is(expected.suit));
		assertThat(actual.no, is(expected.no));
	}

	@Test(expected = IllegalArgumentException.class)
	public void illegalCard0() {
		Card.get('D', 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void illegalCard14() {
		Card.get('D', 14);
	}

	@Test(expected = IllegalArgumentException.class)
	public void illegalSuit() {
		Card.get('X', 14);
	}

}
