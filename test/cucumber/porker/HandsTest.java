package cucumber.porker;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HandsTest {

	private Hands sut;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void before() {
	}

	@Test
	public void カードが5枚() {
		Card[] cards = new Card[5];
		sut = new Hands(cards);

		assertThat(sut, is(notNullValue()));
	}

	@Test
	public void カードが不正枚数_0枚() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("カードの枚数が不正です。枚数：0");

		Card[] cards = new Card[0];
		sut = new Hands(cards);
	}

	@Test
	public void カードが不正枚数_6枚() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("カードの枚数が不正です。枚数：6");

		Card[] cards = new Card[6];
		sut = new Hands(cards);
	}

}
