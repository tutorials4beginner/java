public class CMain {

	public static void main(String[] args) {
		C c1 = new C("I amc thread.");
		C c2 = new C("I am new thread.");

		Thread t = Thread.currentThread();
		try {
			t.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		c1.setPriority(1);
		c2.setPriority(5);

		System.out.println("main is exiting.");
	}
}
