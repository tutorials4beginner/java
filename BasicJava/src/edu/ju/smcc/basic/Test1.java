package edu.ju.smcc.basic;

class Test1 {
	public static void main(String b[]) {
		Integer i1 = new Integer(12);
		System.out.println(i1 + i1.hashCode());
		Float f1 = new Float("12.34f");
		System.out.println(f1);

		Boolean bb = new Boolean("true");
		if (bb)// will fail for java 1.4 or less
			System.out.println("i am a boolean");
		System.out.println("---------------------------------------------");

		Integer i3 = Integer.valueOf("123");// static method

		Integer i4 = Integer.valueOf("1011", 16);

		System.out.println(i3 + " " + i4);
		// using wrapper conversion utility

		Integer t1 = new Integer(100);
		int r1 = t1.intValue();// instance method
		r1++;
		System.out.println(r1);

		Float t2 = new Float(100.23f);
		float r2 = t2.floatValue();// instance method
		r2++;
		System.out.println(r2);

		double d1 = Double.parseDouble("12.56");

		System.out.println(d1);

		int y1 = Integer.parseInt("100");// static method
		System.out.println(y1);

		long h1 = Long.parseLong("100110", 2);
		System.out.println(h1);

		Double d2 = new Double("12.44");
		System.out.println(d2.toString());

		String tr1 = Double.toString(12.45);// static overloaded toString()

		String bt1 = Integer.toHexString(245);
		String bt2 = Long.toOctalString(245);
		System.out.println(bt1);
		System.out.println(bt2);
	}
}
