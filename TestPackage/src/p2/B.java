package p2;

import p1.A;

public class B extends A {
	protected B() {
		super();
	}

	int x;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	void getValues() {
		System.out.println("The values are : " + c + ":" + d);
	}
}
