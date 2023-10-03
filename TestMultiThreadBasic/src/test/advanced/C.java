package test.advanced;

public class C implements Runnable{
	Thread t;
	String name = null;
	
	public C(String str, int p) {
		name = str;
		t = new Thread(this, str);
		t.setPriority(p);
		t.start();
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(name + " I am B constrctr.");
		}
	}
}
