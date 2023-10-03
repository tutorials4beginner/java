package edu.ju.smcc.basic;

//widening beats boxing
//widening beats var-args
//boxing beats var-args

class Test5 {
	static void t1(Byte x, Byte y) {
		System.out.println("Byte,Byte");
	}

	static void t1(byte... x) {
		System.out.println("byte.....");
	}

	public static void main(String b[]) {
		byte c = 5;
		t1(c, c);
	}
}
