package edu.ju.smcc.basic;

class Test9 {
	static void go(Object o) {
		Byte x = (Byte) o;
		System.out.println(x);
	}

	public static void main(String b[]) {
		byte c = 2;
		go(c);
	}
}
