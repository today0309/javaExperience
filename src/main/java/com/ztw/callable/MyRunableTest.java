package com.ztw.callable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyRunableTest {

	public static void main(String[] args) throws Exception {
		int taskSize = 10;
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		CountDownLatch countDownLatch = new CountDownLatch(taskSize);
		for (int i = 0; i < taskSize; i++) {
			pool.execute(new MyRunable(i + " ", countDownLatch));
		}
		countDownLatch.await();
		pool.shutdown();
		System.out.println("任务全部完成");//如果没有countDownLatch.await();任务还没执行完毕就已经执行到这
	}

}
