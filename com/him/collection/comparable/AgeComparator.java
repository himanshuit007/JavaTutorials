package com.him.collection.comparable;

import java.util.*;

public class AgeComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		if (s1.getAge() == s2.getAge())
			return 0;
		else if (s1.getAge() > s2.getAge())
			return 1;
		else
			return -1;
	}
}