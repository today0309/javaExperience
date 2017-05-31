package com.ztw.thread.futureTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskExample1 {

	public static void main(String[] args) {

		MyCallable callable1 = new MyCallable(3000);
		MyCallable callable2 = new MyCallable(5000);

		FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
		FutureTask<String> futureTask2 = new FutureTask<String>(callable2);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(futureTask1);
		executor.execute(futureTask2);

		/**
		 * boolean java.util.concurrent.FutureTask.isDone()
		 * 
		 * 如果此任务完成，返回true。完成可能是由于正常终止，异常或取消-在所有这些情况下，这种方法将返回TRUE。
		 */
		while (true) {
			try {
				if (futureTask1.isDone() && futureTask2.isDone()) {
					System.out.println("Done");
					// shut down executor service
					executor.shutdown();
					return;
				}
				if (!futureTask1.isDone()) {
					// 阻塞futureTask1
					System.out.println("FutureTask1 output=" + futureTask1.get());
				}
				if (!futureTask2.isDone()) {
					// 阻塞futureTask2
					System.out.println("FutureTask2 output=" + futureTask2.get());
				}
			} catch (Exception e) {
				// do nothing
			}
		}

	}
}
