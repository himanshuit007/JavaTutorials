package com.him.design.creational.singletone;

public class ThreadSafeDoubleLockSingleton {

	private static ThreadSafeDoubleLockSingleton instance;

	private ThreadSafeDoubleLockSingleton() {
	}

	public static synchronized ThreadSafeDoubleLockSingleton getInstance() {
		if (instance == null) {
			synchronized (instance) {
				if (instance == null)
					instance = new ThreadSafeDoubleLockSingleton();
			}
		}
		return instance;
	}

}