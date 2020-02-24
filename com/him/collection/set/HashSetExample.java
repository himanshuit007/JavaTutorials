package com.him.collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
	// uses hashing to store element, unique elements,nulls allowed,no ordering
	// initial default capacity of HashSet is 16, and the load factor is 0.75

	public static void main(String args[]) {
		add();
		remove();

		hashSetFromCollection();
	}

	private static void hashSetFromCollection() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Ravi");
		list.add("Vijay");
		list.add("Ajay");

		HashSet<String> set = new HashSet(list);
		set.add("Gaurav");
		Iterator<String> i = set.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

	private static void add() {
		// Creating HashSet and adding elements
		HashSet<String> set = new HashSet();
		set.add("One");
		set.add("Two");
		set.add("Three");
		set.add("Four");
		set.add("Five");
		// will be ignored
		set.add("Five");
		Iterator<String> i = set.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

	private static void remove() {
		HashSet<String> set1 = new HashSet<String>();
		set1.add("Ravi");
		set1.add("Vijay");
		set1.add("Arun");
		set1.add("Sumit");
		System.out.println("An initial list of elements: " + set1);
		// Removing specific element from HashSet
		set1.remove("Ravi");
		System.out.println("After invoking remove(object) method: " + set1);
		HashSet<String> set11 = new HashSet<String>();
		set11.add("Ajay");
		set11.add("Gaurav");
		set11.addAll(set11);
		System.out.println("Updated List: " + set11);
		// Removing all the new elements from HashSet
		set11.removeAll(set11);
		System.out.println("After invoking removeAll() method: " + set11);
		// Removing elements on the basis of specified condition
		set11.removeIf(str -> str.contains("Vijay"));
		System.out.println("After invoking removeIf() method: " + set11);
		// Removing all the elements available in the set
		set11.clear();
		System.out.println("After invoking clear() method: " + set11);
	}
}