package test.copyconstructor;
public class Main {

	public static void main(String[] args) {
		Test t1 = new Test();
		t1.show();
		
		t1.a = 120;

		Test hagu1 = new Test(t1);
		Test hagu2 = new Test(t1);
		t1.show();
		hagu1.show();
		hagu2.show();
	}
}
