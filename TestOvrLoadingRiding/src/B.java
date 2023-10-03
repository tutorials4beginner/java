public class B extends A{
	int b;

	public B() {
		System.out.println("I am B const");
	}
	
	void show(){
		System.out.println("I am B.show()");
	}
	
	void show(int x){
		System.out.println("I am B.show() "+x);
	}
	
	

}
