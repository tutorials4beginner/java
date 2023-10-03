package test.advanced;
public class Caller implements Runnable {
	CallMe cm;
	Thread t;
	String str;

	public Caller(CallMe cm, String str) {
		this.cm = cm;
		this.str = str;
		System.out.println(str+ " started");
		t = new Thread(this);
		t.start();
	}

	public void run() {
		try {
			t.wait(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			cm.show(str);
		
		System.out.println(str + " stoped");
	}
}
