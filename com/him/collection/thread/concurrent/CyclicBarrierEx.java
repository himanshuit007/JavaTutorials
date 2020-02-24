package com.him.collection.thread.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierEx {
	public static void main(String[] args) {
		Runnable barrier1Action = new Runnable() {
			public void run() {
				System.out.println("BarrierAction 1 executed ");
			}
		};
		Runnable barrier2Action = new Runnable() {
			public void run() {
				System.out.println("BarrierAction 2 executed ");
			}
		};

		CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
		CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);

		CyclicBarrierRunnable1 barrierRunnable1 = new CyclicBarrierRunnable1(barrier1, barrier2);

		CyclicBarrierRunnable barrierRunnable2 = new CyclicBarrierRunnable(barrier1, barrier2);

		new Thread(barrierRunnable1).start();
		new Thread(barrierRunnable2).start();
	}

	static class CyclicBarrierRunnable implements Runnable {

		CyclicBarrier barrier1 = null;
		CyclicBarrier barrier2 = null;

		public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {

			this.barrier1 = barrier1;
			this.barrier2 = barrier2;
		}

		public void run() {
			try {
				for (int i = 0; i < 5; i++) {
					System.out.println("Counting "+i +"" +Thread.currentThread().getName());
					Thread.sleep(1000);
				}
				
				System.out.println(Thread.currentThread().getName() + " waiting at barrier 1");
				this.barrier1.await();

				for (int i = 0; i < 5; i++) {
					System.out.println("Counting "+i +"" +Thread.currentThread().getName());
					Thread.sleep(2000);
				}
				
				System.out.println(Thread.currentThread().getName() + " waiting at barrier 2");
				this.barrier2.await();

				System.out.println(Thread.currentThread().getName() + " done!");

			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}
	static class CyclicBarrierRunnable1 implements Runnable {

		CyclicBarrier barrier1 = null;
		CyclicBarrier barrier2 = null;

		public CyclicBarrierRunnable1(CyclicBarrier barrier1, CyclicBarrier barrier2) {

			this.barrier1 = barrier1;
			this.barrier2 = barrier2;
		}

		public void run() {
			try {
				for (int i = 0; i < 10; i++) {
					System.out.println("Counting "+i +"" +Thread.currentThread().getName());
					Thread.sleep(500);
				}
				
				System.out.println(Thread.currentThread().getName() + " waiting at barrier 1");
				this.barrier1.await();

				for (int i = 0; i < 5; i++) {
					System.out.println("Counting "+i +"" +Thread.currentThread().getName());
					Thread.sleep(1000);
				}
				
				System.out.println(Thread.currentThread().getName() + " waiting at barrier 2");
				this.barrier2.await();

				System.out.println(Thread.currentThread().getName() + " done!");

			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
	}

}
