package com.him.collection.list;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArraylistExample {

	public static void main(String[] args) {
		// Resizeble array,insertion order, not synced,random access,slow manipulation
		// Default Capacity 10

//		traversingArrayList();
//
//		serializationDeserialization();

		// addingex();
		// removalEx();

		retainAllex();
		setGetEx();
	}

	private static void setGetEx() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ajay");
		System.out.println("Before update: " + al.get(1));
		// Updating an element at specific position
		al.set(1, "Gaurav");
		System.out.println("After update: " + al.get(1) + " " + al);
	}

	private static void retainAllex() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ajay");
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("Ravi");
		al2.add("Hanumat");
		al.retainAll(al2);
		System.out.println("iterating the elements after retaining the elements of al2");
		Iterator itr = al.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("Is ArrayList Empty: " + al.isEmpty());
	}

	private static void removalEx() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ajay");
		al.add("Anuj");
		al.add("Gaurav");
		System.out.println("An initial list of elements: " + al);
		// Removing specific element from arraylist
		al.remove("Vijay");
		System.out.println("After invoking remove(object) method: " + al);
		// Removing element on the basis of specific position
		al.remove(0);
		System.out.println("After invoking remove(index) method: " + al);

		// Creating another arraylist
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("Ravi");
		al2.add("Hanumat");
		// Adding new elements to arraylist
		al.addAll(al2);
		System.out.println("Updated list : " + al);
		// Removing all the new elements from arraylist
		al.removeAll(al2);
		System.out.println("After invoking removeAll() method: " + al);
		// Removing elements on the basis of specified condition
		al.removeIf(str -> str.contains("Ajay")); // Here, we are using Lambda expression
		System.out.println("After invoking removeIf() method: " + al);
		// Removing all the elements available in the list
		al.clear();
		System.out.println("After invoking clear() method: " + al);
	}

	private static void addingex() {
		ArrayList<String> al = new ArrayList<String>();
		System.out.println("Initial list of elements: " + al);
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ajay");
		System.out.println("After invoking add(E e) method: " + al);

		// Adding an element at the specific position
		al.add(1, "Gaurav");
		System.out.println("After invoking add(int index, E element) method: " + al);
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("Sonoo");
		al2.add("Hanumat");
		// Adding second list elements to the first list
		al.addAll(al2);
		System.out.println("After invoking addAll(Collection<? extends E> c) method: " + al);
		ArrayList<String> al3 = new ArrayList<String>();
		al3.add("John");
		al3.add("Rahul");
		// Adding second list elements to the first list at specific position
		al.addAll(1, al3);
		System.out.println("After invoking addAll(int index, Collection<? extends E> c) method: " + al);
	}

	private static void serializationDeserialization() {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ajay");

		try {
			// Serialization
			FileOutputStream fos = new FileOutputStream("file");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(al);
			fos.close();
			oos.close();
			// Deserialization
			FileInputStream fis = new FileInputStream("file");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList list = (ArrayList) ois.readObject();
			System.out.println(list);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void traversingArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Ravi");
		list.add("Vijay");
		list.add("Ravi");
		list.add("Siddharth");

		// Ways to iterate the elements of the collection in java
		/*
		 * By Iterator interface. By for-each loop. By ListIterator interface. By for
		 * loop. By forEach() method. By forEachRemaining() method
		 */

		System.out.println("Traversing list through for loop:");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// Traversing list through for-each loop
		System.out.println("Traversing list through for-each loop:");
		for (String obj : list)
			System.out.println(obj);

		// Traversing list through Iterator
		System.out.println("Traversing list through Iterator:");
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("Traversing list through List Iterator:");
		// Here, element iterates in reverse order
		ListIterator<String> list1 = list.listIterator(list.size());
		while (list1.hasNext()) {
			String str = list1.next();
			System.out.println(str);
		}
		System.out.println("Reverse Order");
		while (list1.hasPrevious()) {
			String str = list1.previous();
			System.out.println(str);
		}

		System.out.println("Traversing list through forEach() method of List:");
		// The forEach() method is a new feature, introduced in Java 8.
		list.forEach(a -> { // Here, we are using lambda expression
			System.out.println(a);
		});

		System.out.println("Traversing list through forEachRemaining() method of Iterator:");
		Iterator<String> itr1 = list.iterator();

		System.out.println(itr1.next() + "\nRemaining elements");
		itr1.forEachRemaining(a -> // Here, we are using lambda expression
		{
			System.out.println(a);
		});
	}

}
