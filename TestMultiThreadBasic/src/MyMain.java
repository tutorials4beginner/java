public class MyMain {

	
	public static void main(String[] args) {		
		System.out.println("Hello");
		DThread d1 = new DThread("MT-1: ");
		for (int i = 100; i < 105; i++) {
			System.out.println(i);
		}
		System.out.println("Hi");
	}
}
