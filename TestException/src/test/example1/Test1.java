package test.example1;
public class Test1 {

	public static void main(String[] args) {
		int x = 10, y = 5;
		
		try {
			System.out.println("The result is: " + x / y);
		} catch (ArithmeticException e) {
			System.out.println("The exception is" + e);
		} finally {
			System.out.println("I am finally.");
		}
		
		Error e ;
		
		System.out.println("hi......");
	}

}
