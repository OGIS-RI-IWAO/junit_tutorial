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
}
