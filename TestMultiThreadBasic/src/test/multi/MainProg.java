package test.multi;

public class MainProg {

	public static void main(String[] args) {

		Test1Thread t1 = new Test1Thread();
		Thread t2 = new Test2Thread();

		Thread tmain = Thread.currentThread();
		tmain.setPriority(10);
		int i = 0;
		
		t2.resume();
		
		t2.suspend();
		
		while (true) {
			/*try {
				tmain.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}*/
			System.out.println("I am mainThread " + i);
			i++;
		}
		
		
		

	}

}
