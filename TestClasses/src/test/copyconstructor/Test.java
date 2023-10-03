package test.copyconstructor;
public class Test {
	int a;
	int b;

	public Test() {
		a = 10;
		b = 10;
	}

	public Test(Test t) {
		this.a = t.a;
		this.b = t.b;
	}

	void show() {
		System.out.println("a = " + a + " ::  b = " + b);
	}
}
