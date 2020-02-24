package com.him.collection.thread;

public class ThreadEx {
	static int[] buffer;
	static int count = 0;
	static int size = 1000;
	static Object key = new Object();

	static {
		buffer = new int[size];
	}

	public static boolean isFull() {
		return (count == size - 1);
	}

	public static boolean isEmpty() {
		return count == 0;
	}

	static class Producer implements Runnable {

		@Override
		public void run() {
			if (isFull()) {
				synchronized (key) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					notifyAll();

				}
			}
			buffer[count++] = 1;

		}

	}

	static class Consumer implements Runnable {
		@Override
		public void run() {
			synchronized (key) {
				if (isEmpty()) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					notifyAll();
				}
			}
			buffer[count--] = 0;

		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Producer());
		Thread t2 = new Thread(new Consumer());
		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}
}
