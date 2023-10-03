public class DThread extends Thread {

	Thread t;
	String name = "";

	public DThread(String name) {
		this.name = name;
		t = new Thread(this, name);
		t.start();
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				t.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + i);
		}
	}
}
