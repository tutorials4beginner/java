package test.example3;

public class Main {

	public static void main(String args[]) {

		A a1 = new A();
		try {
			try {
				a1.show();
			} catch (ArithmeticException e) {
				
			}
		} catch (ArithmeticException e) {
			System.out.println("Exc: " + e);
		} catch (InvalidAccBalance e) {

		}

	}
}
