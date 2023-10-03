package test.advanced;

public class Main {
	public static void main(String args[]) {
		System.out.println("I am main thread.");
		
		A a1 = new A();
		B b1 = new B("First");
		B b2 = new B("Second");
		B b3 = new B("Third");
		
		/*try {
			b1.t.join();
			b2.t.join();
			b3.t.join();
			a1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		
		
		for (int i = 0; i < 200; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(b1.t.isAlive()+" "+b2.t.isAlive()+" "+b3.t.isAlive());
			
		}
		System.out.println("I am main thread. end");
	}
}
