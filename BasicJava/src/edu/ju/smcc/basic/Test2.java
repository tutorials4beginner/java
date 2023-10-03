package edu.ju.smcc.basic;

class Test2 {
	public static void main(String b[]) {
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		System.out.println(i1 == i2);
		Integer i3 = 123;
		Integer i4 = 123;
		System.out.println(i3 == i4);
		Integer i5 = 129;
		Integer i6 = 129;
		System.out.println(i5 == i6);
		System.out.println(i5.equals(i6));
		System.out.println("-----------------------");
		// for java 4 people
		Integer y1 = new Integer(100);
		int r1 = y1.intValue();
		r1++;
		Integer y2 = new Integer(r1);
		System.out.println(y2);

		// for java 5 and above
		Integer y3 = new Integer(100);
		y3++;
		Integer y4 = new Integer(y3);
		System.out.println(y4);

	}
}
