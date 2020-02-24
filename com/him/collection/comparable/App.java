package com.him.collection.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class App {
	public static void main(String[] args) {
		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student("Viru", 1, 12, 34));
		al.add(new Student("Saurav", 2, 23, 45));
		al.add(new Student("Mukesh", 3, 21, 43));
		al.add(new Student("Tahir", 4, 45, 87));
		al.add(new Student(null, 4, 45, 87));

		Collections.sort(al);
		for (Student s : al) {
			System.out.println(s.getName());
		}

		Collections.sort(al, Collections.reverseOrder());
		Iterator i = al.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

		ArrayList<Integer> al1 = new ArrayList<>(); 
		al1.add(Integer.valueOf(201));
		al1.add(Integer.valueOf(101));
		al1.add(230);// internally will be converted into objects as Integer.valueOf(230)

		Collections.sort(al1);

		Iterator<Integer> itr = al1.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("Sorting by Name");

		Collections.sort(al, new NameComparator());
		Iterator<Student> itr1 = al.iterator();
		while (itr1.hasNext()) {
			Student st = (Student) itr1.next();
			System.out.println(st.getRollno() + " " + st.getName() + " " + st.getAge());
		}

		System.out.println("Sorting by age");

		Collections.sort(al, new AgeComparator());
		Iterator<Student> itr2 = al.iterator();
		while (itr2.hasNext()) {
			Student st = (Student) itr2.next();
			System.out.println(st.getRollno() + " " + st.getName() + " " + st.getAge());
		}

		Comparator<Student> cm1 = Comparator.comparing(Student::getName);
		Collections.sort(al, cm1);
		System.out.println("Sorting by Name");
		for (Student st : al) {
			System.out.println(st.getRollno() + " " + st.getName() + " " + st.getAge());
		}

		Comparator<Student> cm2 = Comparator.comparing(Student::getAge);
		Collections.sort(al, cm2);
		System.out.println("Sorting by Age");
		for (Student st : al) {
			System.out.println(st.getRollno() + " " + st.getName() + " " + st.getAge());
		}

		Comparator<Student> cm11 = Comparator.comparing(Student::getName, Comparator.nullsFirst(String::compareTo));
		Collections.sort(al, cm11);
		System.out.println("Considers null to be less than non-null");
		for (Student st : al) {
			System.out.println(st.getRollno() + " " + st.getName() + " " + st.getAge());
		}
		Comparator<Student> cm21 = Comparator.comparing(Student::getName, Comparator.nullsLast(String::compareTo));
		Collections.sort(al, cm21);
		System.out.println("Considers null to be greater than non-null");
		for (Student st : al) {
			System.out.println(st.getRollno() + " " + st.getName() + " " + st.getAge());
		}
	}
}
