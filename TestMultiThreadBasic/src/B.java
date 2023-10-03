
public class B implements Runnable {
	int i = 0;
	String name;
	Thread t;
	//Thread remref;

	public B(String name, Thread a1) {
		this.name = name;
		//remref = a1;
		t = new Thread(this, "B thread");
		System.out.println(name + "i am B const");
		t.start();
	}

	public void run() {
		for (; i < 10000;) {
//			try {
//				t.sleep(3000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println(name + i);
			i += 2;
		}
	}
}
