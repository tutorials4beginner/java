package testinterface;

public class YourCalculator implements MyCalculatorInterface {

	public int add(int p, int q) {
		return p + q;
	}

	public int sub(int x, int y) {

		return x - y;
	}

	public int mul(int x, int y) {
		int res = 1;
		for (int i = 1; i <= y; i++)
			res = res * x;
		return res;
	}

	public int div(int x, int y) {
		return x / y;
	}

}
