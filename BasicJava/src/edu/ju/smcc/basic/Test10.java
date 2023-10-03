package edu.ju.smcc.basic;

/*
 primitive widening uses the smallest method arg possible
 used individually,boxing and var-args are compatible with overloading
 U can not widen from one wrapper type to another(IS-A fails)
 U can not widen and then box(An int can't become a Long)
 U can box and then widen(An int can become an Object , via Integer)
 U can combine var-args with either widening or boxing.
 */

class Test10 {
	static void go(long... x) {
		System.out.println("long....x");
	}

	static void go2(Integer... x) {
		System.out.println("Integer....x");
	}

	public static void main(String b[]) {
		int i = 12;
		go(i, i);
		go2(i, i);
	}
}
