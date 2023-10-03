package com.t4b.test;

public class Item {
	String name;
	int id;
	double price;

	public Item(String name, int id, double price) {
		super();
		this.name = name;
		this.id = id;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", id=" + id + ", price=" + price + "]";
	}
}