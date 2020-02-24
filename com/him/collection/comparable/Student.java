package com.him.collection.comparable;

public class Student implements Comparable<Student> {
	private String name;
	private int id;
	
	private int rollno;  
	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", rollno=" + rollno + ", age=" + age + "]";
	}

	
	public Student(String name, int id, int rollno, int age) {
		super();
		this.name = name;
		this.id = id;
		this.rollno = rollno;
		this.age = age;
	}

	@Override
	public int compareTo(Student o) {
		 return name.compareTo(o.name);  
	}

}