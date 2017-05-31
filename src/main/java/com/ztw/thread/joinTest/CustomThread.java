package com.ztw.thread.joinTest;

public class CustomThread extends Thread {

	CustomThread1 t1;

	public CustomThread(CustomThread1 t1) {
		super("[CustomThread] Thread");
		this.t1 = t1;
	}

	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println("CustomThread: " + threadName + " start.");
		try {
			// System.out.println("start CustomThread join");
			for (int i = 0; i < 5; i++) {
				System.out.println(threadName + " Custom at " + i);

			}
			t1.join();
			for (int i = 6; i < 10; i++) {
				System.out.println(threadName + " Custom at " + i);

			}
			System.out.println("CustomThread: " + threadName + " end.");
		} catch (Exception e) {
			System.out.println("Exception from " + threadName + ".run");
		}
	}
	
}
