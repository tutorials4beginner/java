public class Main {

	public static void main(String[] args) {
		System.out.println("i am main meth");
		A a1 = new A("T-A-1 :");
		A a2 = new A("T-A-2 :");
		A a3 = new A("T-A-3 :");
		B b1 = new B("T-B-1 :", a1);
		//b1.t.stop();
		// a1.t.setPriority(2);
		// a2.t.setPriority(5);
		try {
			a1.t.join();
			a2.t.join();
			a3.t.join();
			b1.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// System.out.println(a1.t.isAlive());
			// System.out.println(b1.t.isAlive());
		}
		System.out.println("End of main.");
	}
}
