package edu.ju.smcc.basic;

//widening beats boxing
//widening beats var-args
class test4 {
	static void t1(int x, int y) {
		System.out.println("int,int");
	}

	static void t1(byte... x) {
		System.out.println("byte.....");
	}

	public static void main(String b[]) {
		t1(5, 3);
	}
}
