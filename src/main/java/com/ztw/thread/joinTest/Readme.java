package com.ztw.thread.joinTest;


/**
 * join()方法源码
 * @author Administrator
 *
 */
public class Readme {
	
	public final native boolean isAlive();

	public final synchronized void join(long millis) throws InterruptedException {
		long base = System.currentTimeMillis();
		long now = 0;

		if (millis < 0) {
			throw new IllegalArgumentException("timeout value is negative");
		}

		if (millis == 0) {
			while (isAlive()) {
				wait(0);
			}
		} else {
			while (isAlive()) {
				long delay = millis - now;
				if (delay <= 0) {
					break;
				}
				wait(delay);
				now = System.currentTimeMillis() - base;
			}
		}
	}

}
