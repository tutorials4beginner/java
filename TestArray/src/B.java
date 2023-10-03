

public class B {
	int b ;
	int a[]={10,30,20};
	
	public B(int b){
		this.b=b;
		System.out.println("1");
		for(int x: a){
			System.out.println(x);
		}
	}
	public B(int b, int c){
		this.b=b;
		System.out.println("2");
	}

}
