package test.advanced;
public class CallMe {
	synchronized void show(String str) {
		System.out.println("["+str);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("]");
	}
}
