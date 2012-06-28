package junit.tutorial;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import junit.rules.AssertionMessage;

import org.junit.Assume;
import org.junit.Rule;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class CalculatorParameterizedTest {
	@RunWith(Theories.class)
	public static class 乗算メソッドのパラメータ化テスト {
		@DataPoint public static Fixture DATA1 = new Fixture(3, 4, 12);
		@DataPoint public static Fixture DATA2 = new Fixture(5, 7, 35);
		@Theory
		public void multiplyで乗算結果が取得できること(Fixture fx) {
			Assume.assumeTrue(fx.x != 0);
			System.out.println(fx.x + " * " + fx.y + " = " + fx.expected);
			Calculator calc = new Calculator();
			int expected = fx.expected;
			int actual = calc.multiply(fx.x, fx.y);
			assertThat(actual, is(expected));
		}
		static class Fixture {
			int x, y, expected;
			public Fixture(int x, int y, int expected) {
				this.x = x;
				this.y = y;
				this.expected = expected;
			}
		}
		
		
		@Theory
		public void multiplyで3と4の乗算結果が取得できること() {
			Calculator calc = new Calculator();
			int expected = 12;
			int actual = calc.multiply(3, 4);
			assertThat(actual, is(expected));
		}
		
		@Theory
		public void multiplyで5と7の乗算結果が取得できること() {
			Calculator calc = new Calculator();
			int expected = 35;
			int actual = calc.multiply(5, 7);
			assertThat(actual, is(expected));
		}
	}
	
    @RunWith(Theories.class)
    public static class 除算メソッドのパラメータ化テスト {
        @Rule
        public AssertionMessage message = new AssertionMessage();
        @DataPoints
        public static Fixture[] DATAs = {
                new Fixture(3, 2, 1.5f),
                new Fixture(10, 2, 5f),
                new Fixture(3, 0, null),
                new Fixture(10, 0, null),
        };
        @Rule
        public ExpectedException exception = ExpectedException.none();

        @Theory
        public void divideで除算結果が取得できること(Fixture fx) {
            Assume.assumeTrue(fx.y != 0);
            message.append("case: %d / %d = %f", fx.x, fx.y, fx.expected);
            Calculator calc = new Calculator();
            float expected = fx.expected;
            float actual = calc.divide(fx.x, fx.y);
            assertThat(actual, is(expected));
        }

        @Theory
        public void divideの第２引数に0を指定した場合にはIllegalArgumentExceptionを送出する(Fixture fx) {
            Assume.assumeTrue(fx.y == 0);
            message.append("case: %d / %d > Exception", fx.x, fx.y);
            exception.expect(IllegalArgumentException.class);
            Calculator calc = new Calculator();
            calc.divide(fx.x, fx.y);
        }

        static class Fixture {
            int x, y;
            Float expected;

            Fixture(int x, int y, Float expected) {
                this.x = x;
                this.y = y;
                this.expected = expected;
            }
        }
    }

}
