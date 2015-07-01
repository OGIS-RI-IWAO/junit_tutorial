package junit.tutorial;

import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class TimeoutExampleTest {
	@Rule
	public Timeout timeout = new Timeout(100);
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void test_50millis() throws Exception {
		Thread.sleep(50);
	}

	@Test(expected=Exception.class)
	public void test_200millis() throws Exception {
		exception.expect(Exception.class);
		Thread.sleep(200);
	}

	@Test(timeout=30)
	public void test_30millis() throws Exception {
		exception.expect(Exception.class);
		Thread.sleep(50);
	}

}
