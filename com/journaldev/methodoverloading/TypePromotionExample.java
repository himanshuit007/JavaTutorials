package com.journaldev.methodoverloading;

public class TypePromotionExample {

	void add(float dataOne, float dataTwo) {
		System.out.println(dataOne + dataTwo + " type float");
	}

	void add(long dataOne, long dataTwo) {
		System.out.println(dataOne + dataTwo + " type long");
	}

	public static void main(String[] args) {
		TypePromotionExample tpe = new TypePromotionExample();
		tpe.add(5, 5); // integer values are passed
		
		System.out.println("This is journaldev.com".substring(8,18));
	}

}