package edu.msit.cse;

public class A implements I{
	protected int a = 10;

	public void show() {
		System.out.println(a);
		System.out.println("I am A.show");
	}

	public void dispaly() {
		System.out.println("I am dispaly.");
		
	}
}