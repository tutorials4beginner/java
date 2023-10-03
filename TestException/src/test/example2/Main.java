package test.example2;
public class Main {
	public static void main(String[] args) {
		try {
			new Num().div();
		} catch (Exception e) {
			System.out.println("Error due to division by zero");
			e.printStackTrace();
		}
	}
}
