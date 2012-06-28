package junit.matcher;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static junit.matcher.IsDate.dateOf;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

public class IsDateExamples {

	@Test
	@Ignore("このテストは失敗します")
	public void dateOfの利用() throws Exception {
		Date actual = new Date();
		assertThat(actual, is(dateOf(2012, 1, 12)));
	}
	
}
