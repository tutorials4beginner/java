public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		B b1 = new B();

		System.out.println("##########################");
		System.out.println(b1.b);

		b1.show();
		b1.show(38);

		System.out.println(b1.a);

		C c1 = new C();
		int res = c1.add(10, 20);
		System.out.println(res);

	}
}
