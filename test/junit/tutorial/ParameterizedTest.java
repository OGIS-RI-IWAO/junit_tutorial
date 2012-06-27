package junit.tutorial;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class ParameterizedTest {
//	@Theory
//	public void testCase(int x) throws Exception {
//	}
	@DataPoint
	public static int INT_PARAM_1 = 3;
	@DataPoint
	public static int INT_PARAM_2 = 4;
	
	public ParameterizedTest() {
		System.out.println("初期化");
	}
	
	@Theory
	public void test(int param) throws Exception {
		System.out.println("test(" + param + ")");
	}
}
