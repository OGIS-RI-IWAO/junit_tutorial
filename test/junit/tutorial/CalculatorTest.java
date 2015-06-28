package junit.tutorial;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void multiplyで3と4の乗算結果が取得できること() {
		Calculator calc = new Calculator();
		int expected = 12;
		int actual = calc.multiply(3, 4);
		assertThat(actual, is(expected));
	}
	
	@Test
	public void multiplyで5と7の乗算結果が取得できること() {
		Calculator calc = new Calculator();
		int expected = 35;
		int actual = calc.multiply(5, 7);
		assertThat(actual, is(expected));
	}
	
	@Test
	public void divideで3と２の除算結果が取得できる() {
		Calculator calc = new Calculator();
		float expected = 1.5f;
		float actual = calc.divide(3, 2);
		assertThat(actual, is(expected));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void divideで第2引数に0を設定した場合にはilleagalArgumentExceptionを送出する() {
		Calculator calc = new Calculator();
		calc.divide(5, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void divideで第1引数に0を設定した場合にはilleagalArgumentExceptionを送出する() {
		Calculator calc = new Calculator();
		calc.divide(0, 5);
	}

}
