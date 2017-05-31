package com.ztw.thread.futureTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskExample4 {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

	private static int n = 0;

	public static void main(String[] args) throws Exception {

		MyCallable callable1 = new MyCallable(500);

		FutureTask<String> futureTask1 = new FutureTask<String>(callable1);

		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.execute(futureTask1);

		while (true) {
			String result1;
			System.out.println(sdf.format(new Date()) + ": 开始循环第" + ++n + "次");
			if (futureTask1.isDone()) {
				result1 = futureTask1.get();
				System.out.println(sdf.format(new Date()) + ": " + result1);
				executor.shutdown();
				return;
			}
			result1 = futureTask1.get(300L, TimeUnit.MILLISECONDS);
			System.out.println(sdf.format(new Date()) + ": 任务1没有执行完毕");
		}
	}

}
