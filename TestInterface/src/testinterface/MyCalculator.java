package testinterface;

public class MyCalculator implements MyCalculatorInterface {

	public int add(int x, int y) {
		return x + y;
	}

	public int sub(int x, int y) {
		return x - y;
	}

	public int mul(int x, int y) {
		return x * y;
	}

	public int div(int x, int y) {
		return x / y;
	}

	public int mod(int x, int y) {
		return x % y;
	}

}
