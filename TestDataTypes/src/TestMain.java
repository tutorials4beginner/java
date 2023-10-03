public class TestMain {

	public static void main(String args[]) {
		// Integers......
		byte b = 111;
		short s = 11111;
		int in = 1111111111;
		long ln = 1111111111;

		// Floating Point Numbers
		int x = 22, y = 7;
		float resf = (float) x / y;
		System.out.println("The value of Pi is .... " + resf);

		double resd = (double) x / y;
		System.out.println("The value of Pi is .... " + resd);

		// Characters and Strings....
		char c = '#';
		System.out.println(c);

		// Booleans.....
		boolean bool = true;
		System.out.println(bool);

		System.out.println("-------------------------");
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}

		System.out.println("\n-------------------------");
		for (int temp : arr) {
			System.out.print(temp);
		}
	}
}
