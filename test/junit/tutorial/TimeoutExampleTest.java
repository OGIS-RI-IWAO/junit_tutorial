package junit.tutorial;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TimeoutExampleTest {
	@Rule
	public Timeout timeout = new Timeout(100);
	@Test
	public void test() throws Exception {
	}

}
