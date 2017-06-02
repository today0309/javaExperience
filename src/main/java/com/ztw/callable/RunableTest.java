package com.ztw.callable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunableTest {

	public static void main01(String[] args) {
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				System.out.println(Thread.currentThread().getName() + "前面："
						+ DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()) + "=>" + index);
				Thread.sleep(index * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + "后面："
							+ DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()) + "=>" + index);
				}
			});
		}
	}

	public static void main(String[] args) {
		ExecutorService fixedThreadPool = Executors.newCachedThreadPool();
				//Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName() + "前面："
								+ DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()) + "=>" + index);
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

}
