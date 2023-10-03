public class A extends Thread {
	int i = 1;
	String name;
	public Thread t;

	public A(String name) {
		this.name = name;
		t = new Thread(this, "A thread");
		System.out.println(name + "i am A const");
		t.start();
	}

	public void run() {
		for (; i < 10000;) {
			System.out.println(name + i);
			i += 2;
		}
	}
}
