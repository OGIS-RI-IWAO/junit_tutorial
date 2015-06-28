package junit.tutorial;

public class Calculator {
	
	public int multiply(int x, int y) {
		return x * y;
	}
	
	public float divide(int x, int y) {
		if(x == 0 || y == 0) throw new IllegalArgumentException();
		return (float)x / (float)y;
	}

}
