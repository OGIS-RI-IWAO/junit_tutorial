package junit.tutorial;

import org.junit.Before;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class ParameterizedTest {
	@DataPoint
	public static int INT_PARAM_1 = 3;
	@DataPoint
	public static int INT_PARAM_2 = 4;
	
	public ParameterizedTest() {
		System.out.println("初期化");
	}
	
	@Before
	public void setUp() {
		System.out.println("before");
	}
	
	@Theory
	public void test(int param) throws Exception {
		System.out.println("test(" + param + ")");
	}
}
