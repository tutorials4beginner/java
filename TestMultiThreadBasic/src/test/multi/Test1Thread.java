package test.multi;

public class Test1Thread implements Runnable {
	Thread t;

	public Test1Thread() {
		t = new Thread(this, "Test1Thread");
		t.setPriority(1);
		System.out.println("Child thread");
		t.start();
	}

	public void run() {
		int i = 0;
		while (true) {
			/*try {
				t.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			System.out.println("I am thread1 " + i);
			i++;
		}
	}
}
