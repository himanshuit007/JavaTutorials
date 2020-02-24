package com.him.innerclass;
public class MemberInner {

	private int x = 7;

	protected class MyInner {
		public void seeOuter() {
			System.out.println("Outer x is " + x);
			System.out.println("Outer x is " + MemberInner.this);// Access outer instance //from inner class
		}
	}

	public void makeInner() {
		MyInner in = new MyInner(); // make an inner instance
		in.seeOuter();
	}
	public static void main(String[] args) {
		MemberInner mo = new MemberInner(); // gotta get an instance!
		MemberInner.MyInner inner = mo.new MyInner();
		inner.seeOuter();

		MemberInner.MyInner inner1 = new MemberInner().new MyInner();
		inner1.seeOuter();
	}
	
}

class Ex{
	public static void main(String[] args) {
		MemberInner mo = new MemberInner(); // gotta get an instance!
		MemberInner.MyInner inner = mo.new MyInner();
		inner.seeOuter();

		MemberInner.MyInner inner1 = new MemberInner().new MyInner();
		inner1.seeOuter();
	}
}