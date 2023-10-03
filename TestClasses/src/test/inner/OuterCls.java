package test.inner;
public class OuterCls {
	int a;

	public class B extends NormalCls{
		int b;

		public int getB() {
			return b;
		}

		public void showInner() {
			showOuter();
			System.out.println(b + "" + a);
		}
	};

	public void showOuter() {
		// showInner();
		System.out.println(a + " " + new B().getB());
	}
}
