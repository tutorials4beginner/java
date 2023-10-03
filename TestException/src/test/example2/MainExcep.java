package test.example2;
public class MainExcep {
	public static void main(String[] args) {
		try {
			new TestExcep().check();
		} catch (MyException e) {
			e.printStackTrace();
		}

		new TestExcep().check1();
	}
}
