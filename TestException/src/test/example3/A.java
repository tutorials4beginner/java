package test.example3;

public class A {
	final int a = 5;

	void show() throws InvalidAccBalance{
		int acc_bal = 100;
		if (acc_bal < 1000) {
			throw new InvalidAccBalance("Balance is less than 1000.");
		}
	}
}
