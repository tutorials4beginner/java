package test.advanced;
public class A extends Thread {
	public A() {
		start();
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("I am A constrctr.");
		}
	}
}
