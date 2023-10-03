package test.differentway;

public class TestThread extends Thread{
	public TestThread() {
		start();
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("I am TestThread run method.");
		}
	}
}
