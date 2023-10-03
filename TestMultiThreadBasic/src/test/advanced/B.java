package test.advanced;
public class B implements Runnable {
	Thread t;
	String name = null;

	public B(String str) {
		name = str;
		t = new Thread(this, str);
		t.start();
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				t.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(name + " I am B constrctr.");
		}
	}

}
