package cucumber.porker;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import cucumber.annotation.ja.ならば;
import cucumber.annotation.ja.もし;
import cucumber.annotation.ja.前提;

public class PokerGameStepDefs {
	
	PorkerGame sut;
	
	@前提("^手札に([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+),([SHDC])(\\d+)が配られた$")
	public void 手札にS_H_D_D_C_が配られた(
			char suite1, int no1, 
			char suite2, int no2, 
			char suite3, int no3, 
			char suite4, int no4, 
			char suite5, int no5) throws Throwable {
	    sut = new PorkerGame();
	    sut.setUp(Card.get(suite1, no1),
	    		Card.get(suite2, no2),
	    		Card.get(suite3, no3),
	    		Card.get(suite4, no4),
	    		Card.get(suite5, no5));
	}

	@もし("^チェンジしない$")
	public void チェンジしない() throws Throwable {
	    sut.noChange();
	}

	@ならば("^ノーペアであるべき$")
	public void ノーペアであるべき() throws Throwable {
	    Pat result = sut.pat();
	    assertThat(result, is(Pat.NO_PAIR));
	}
	
	@ならば("^(\\d+)のワンペアであるべき$")
	public void のワンペアであるべき(int no) throws Throwable {
	    Pat expected = new Pat.OnePair(no);
	    assertThat(sut.pat(), is(expected));
	}
	
	@ならば("^(\\d+)と(\\d+)のツーペアであるべき$")
	public void のツーペアであるべき(int no1, int no2) throws Throwable {
	    Pat expected = new Pat.TwoPairs(no1, no2);
	    assertThat(sut.pat(), is(expected));
	}
	
	@ならば("^(\\d+)のスリーカードであるべき$")
	public void のスリーカードであるべき(int no) throws Throwable {
	    Pat expected = new Pat.ThreeCards(no);
	    assertThat(sut.pat(), is(expected));
	}
	
	@ならば("^ストレートであるべき$")
	public void ストレートであるべき() throws Throwable {
	    Pat expected = new Pat.Straight();
	    assertThat(sut.pat(), is(expected));
	}
	
	@ならば("^フラッシュであるべき$")
	public void フラッシュであるべき() throws Throwable {
	    Pat expected = new Pat.Flash();
	    assertThat(sut.pat(), is(expected));
	}
	
	@ならば("^(\\d+)と(\\d+)のフルハウスであるべき$")
	public void のフルハウスであるべき(int no1, int no2) throws Throwable {
	    Pat expected = new Pat.Fullhouse(no1, no2);
	    assertThat(sut.pat(), is(expected));
	}
	
	@ならば("^(\\d+)のフォーカードであるべき$")
	public void フォーカードであるべき(int no) throws Throwable {
	    Pat expected = new Pat.FourCards(no);
	    assertThat(sut.pat(), is(expected));
	}
	
	@ならば("^ストレートフラッシュであるべき$")
	public void ストレートフラッシュであるべき() throws Throwable {
	    Pat expected = new Pat.StraightFlash();
	    assertThat(sut.pat(), is(expected));
	}
	
	@ならば("^ロイヤルストレートフラッシュであるべき$")
	public void ロイヤルストレートフラッシュであるべき() throws Throwable {
	    Pat expected = new Pat.RoyalStraightFlash();
	    assertThat(sut.pat(), is(expected));
	}
}
