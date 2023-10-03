package test.example1.pkg2;
import test.example1.pkg1.A;

public class B extends A {
	private int b_priv;
	public int pub = 10;
	protected int b_pro;
	int b_def;

	public void showData() {
		System.out.println(b_priv);
		System.out.println(pub);
		System.out.println(b_pro);
		System.out.println(b_def);
		
		//System.out.println(priv);
		System.out.println(pub);
		System.out.println(pro);
		//System.out.println(def);
	}
}
