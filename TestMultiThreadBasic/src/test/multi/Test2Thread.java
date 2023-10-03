package test.multi;

public class Test2Thread extends Thread {

	public Test2Thread() {
		super("Test2Thread Super");
		this.setPriority(5);
		start();
	}

	public void run() {
		int i = 0;
		while (true) {
			/*try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			System.out.println("I am thread2 " + i);
			i++;
		}
	}
}
