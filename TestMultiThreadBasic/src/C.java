import java.util.Random;

public class C extends Thread {
	String name;
	Thread t;
	int i = 0;

	public C(String n) {
		this.name = n;
		t = new Thread(this, n);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		for (i = 0; i <= 100; i++) {
			System.out.println(name + " :" + i);
			try {
				sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
