package com.him.collection.set;

import java.util.*;

public class LinkedHashSetExample {
	public static void main(String args[]) {
		
		
		add();
	}

	private static void add() {
		// Creating HashSet and adding elements
		LinkedHashSet<String> set = new LinkedHashSet();
		set.add("One");
		set.add("Two");
		set.add("Three");
		set.add("Four");
		set.add("Five");
		set.add("Five");
		Iterator<String> i = set.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
}