package com.him.innerclass;

public class CaseOfThePrivateInterface {
	private interface Secret {
		public void shh();
	}

	class Dont_Tell implements Secret {
		public void shh() {
		}
	}
}
