package com.t4b.test;

import java.util.Comparator;

public class NameComparator implements Comparator<Item>{

	@Override
	public int compare(Item o1, Item o2) {
		return o1.name.compareTo(o2.name);
	}
}
