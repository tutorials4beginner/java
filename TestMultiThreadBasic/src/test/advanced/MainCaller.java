package test.advanced;
public class MainCaller {

	public static void main(String[] args) {
		CallMe cm = new CallMe();
		
		
		Caller c1 = new Caller(cm, "First");
		Caller c2 = new Caller(cm, "Second");
		Caller c3 = new Caller(cm, "Third");
	}
}
