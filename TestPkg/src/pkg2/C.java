package pkg2;

import pkg1.A;

public class C {

	void print() {
		A a = new A();
		System.out.println(a.pub);
		
		D d = new D();
		System.out.println(d.pub);
	}
}
