package com.him.oop;

public class Main {

	// static initializer
	static {
		System.out.println("Inside static initializer");
	}
	// instance initializer
	{
		System.out.println("Inside instance initializer");
	}

	// constructor
	public Main() {
		System.out.println("Inside constructor");
	}

	public static void main(String[] args) {
		new Main();

		new Main();
	}
}