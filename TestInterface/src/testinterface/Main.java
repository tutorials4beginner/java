package testinterface;

public class Main {

	public static void main(String[] args) {
		MyCalculator mc = new MyCalculator();
		YourCalculator yc = new YourCalculator();
		System.out.println(mc.add(10, 20));
		System.out.println(yc.add(10, 20));
		System.out.println(mc.sub(10, 20));
		System.out.println(yc.sub(10, 20));

	}

}
