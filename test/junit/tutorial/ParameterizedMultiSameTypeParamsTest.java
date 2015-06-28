package junit.tutorial;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class ParameterizedMultiSameTypeParamsTest {
	@DataPoint
	public static int INT_PARAM_1 = 3;
	@DataPoint
	public static int INT_PARAM_2 = 4;
	
	/**
	 * DataPointによる全組み合わせが実行される
	 * @param x
	 * @param y
	 */
	@Theory
	public void test(int x, int y) {
		System.out.println("test(" + x + ", " + y + ")");
	}
}
