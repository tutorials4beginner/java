package com.t4b.test;

import java.util.ArrayList;

public class TestMain {

	public static void main(String[] args) {
		ArrayList<Item> items = new ArrayList<Item>();

		// add items
		items.add(new Item("Apple", 1, 150.0));
		items.add(new Item("Grape", 2, 250.0));
		items.add(new Item("Bag", 3, 1050.0));

		Item itm = new Item("Mango", 4, 100);
		items.add(itm);
		System.out.println(items.size());
		// remove item
		items.remove(1);
		items.remove(itm);
		System.out.println(items.size());

		ArrayList<Item> otherItems = new ArrayList<Item>();
		otherItems.add(new Item("Bag", 3, 1050.0));
		otherItems.add(new Item("Mango", 4, 100));
		// add a list to another list
		System.out.println(items.size());
		items.addAll(otherItems);
		System.out.println(items.size());

		// iterate over the list
		for (Item i : items) {
			System.out.println(i);
		}
	}
}
