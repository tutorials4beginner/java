package edu.msit.cse;

public class B extends A{
	int b=20;
	
	public void show(){
		System.out.println(a);
		System.out.println(b);
		super.show();
		System.out.println("I am B.show");
	}
}
