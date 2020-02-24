package com.him.innerclass;

class StaticNested {
	static int data = 30;

	static class Inner {
		void msg() {
			System.out.println("data is " + data);
		}
	}

	public static void main(String args[]) {
		StaticNested.Inner obj = new StaticNested.Inner();
		obj.msg();
	}
}