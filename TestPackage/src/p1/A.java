package p1;
public class A {
	private int a;
	int b;
	protected String c;
	public float d;

	protected A() {
		this.a = 10;
		this.b = 10;
		this.c = "";
		this.d = 10;
		System.out.println("I am parameter less constructor" + a + ":" + b
				+ ":" + c + ":" + d);
	}

	A(int a, int b, String c, float d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		System.out.println("I am parameterized constructor" + a + ":" + b + ":"
				+ c + ":" + d);
	}

	public A(A acons) {
		this.a = acons.a;
		this.b = acons.b;
		this.c = acons.c;
		this.d = acons.d;
		System.out.println("I am parameterized constructor" + a + ":" + b + ":"
				+ c + ":" + d);

	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public float getD() {
		return d;
	}

	public void setD(float d) {
		this.d = d;
	}
	
	void getValues(){
		System.out.println("The values are : " + a + ":" + b + ":"
				+ c + ":" + d);
	}
}
