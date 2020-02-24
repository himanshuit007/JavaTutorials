package com.him.innerclass;



public class Test {
	private int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public Test(int a) {
		super();
		this.a = a;
	}

	class Inner {
		public int getA() {
			return a;
		}
	}

	public static void main(String[] args) {
		Test t = new Test(5);
//		Test.Inner in = t.Inner();

	}
}
