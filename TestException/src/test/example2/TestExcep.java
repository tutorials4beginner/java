package test.example2;
public class TestExcep {
	int accbal = 500;

	void check() throws MyException {
		if (accbal < 1000) {
			throw new MyException();
		} else {
			System.out.println("Sufficient balance.");
		}
	}
	
	void check1() {
		if (accbal < 1000) {
			try {
				throw new MyException();
			} catch (MyException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Sufficient balance.");
		}
	}
}
