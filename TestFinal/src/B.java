public class B extends Thread{

	final int i = 10;

	final void print(int i) {
		System.out.println(i);
		A a1 = new A();
	}

}
