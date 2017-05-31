package com.ztw.thread.futureTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


public class FutureTaskExample2 {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

	public static void main(String[] args) {

		MyCallable callable1 = new MyCallable(3000);
		MyCallable callable2 = new MyCallable(6000);

		FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
		FutureTask<String> futureTask2 = new FutureTask<String>(callable2);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(futureTask1);
		executor.execute(futureTask2);

		while (true) {
			System.out.println(sdf.format(new Date()) + "***********************");
			try {
				if (futureTask1.isDone() && futureTask2.isDone()) {
					System.out.println(sdf.format(new Date()) + "Done");
					// shut down executor service
					executor.shutdown();
					System.out.println("will return");
					return;
				}

				if (!futureTask1.isDone()) {
					// 阻塞futureTask1
					System.out.println(sdf.format(new Date()) + "FutureTask1 output=" + futureTask1.get());
				}

				System.out.println(sdf.format(new Date()) + "Waiting for FutureTask2 to complete");
				String s = futureTask2.get(2000L, TimeUnit.MILLISECONDS); // 阻塞500毫秒
				if (s != null) {
					System.out.println(sdf.format(new Date()) + "FutureTask2 output=" + s);
				} else {
					System.out.println(sdf.format(new Date()) + "FutureTask2 output is null");
				}
			} catch (Exception e) {
				// do nothing
			}
		}

	}
}
