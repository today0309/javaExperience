package com.ztw.thread.sellTicket;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

public class Main {
	
	private static final int executorNum = 5;

	// 创建固定大小的线程池
	private static ExecutorService executor = Executors.newFixedThreadPool(executorNum);
	
	CountDownLatch countDownLatch = new CountDownLatch(executorNum);
	
	@Test
	public void test001() throws Exception{
		for(int i=0; i < executorNum; i++){
			SellTicket sellTicket = new SellTicket("A_" + i, countDownLatch);
			executor.execute(sellTicket);
		}
		countDownLatch.await();
	}
	
	@Test
	public void test000() throws Exception{
		Thread thread1 = new Thread(new SellTicket("A", countDownLatch));
		Thread thread2 = new Thread(new SellTicket("B", countDownLatch));
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
