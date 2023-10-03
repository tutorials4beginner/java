package test.differentway;
public class Main {

	public static void main(String[] args) {
		TestThread tt = new TestThread();
		tt.setPriority(1);
		TestRunnable tr = new TestRunnable("Sweety");
		tr.t.setPriority(5);
	}
}
