package com.him.collection.thread;

public class SimpleLock {
	Object myObject = new Object();
	boolean wasSignalled = false;

	public void lock() {
		synchronized (myObject) {
			while (!wasSignalled) {
				try {
					myObject.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			wasSignalled = false;
		}
	}

	public void unlock() {
		synchronized (myObject) {
			wasSignalled = true;
			myObject.notify();
		}
	}
}
