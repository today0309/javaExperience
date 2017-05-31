package com.ztw.thread.threadPool.runnable;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.springframework.stereotype.Component;


@Component
public class Data2RedisThread implements Runnable {

	private List<String> list;

	private CountDownLatch countDownLatch;

	private static Object locl_obj = new Object();
	
	@SuppressWarnings("unused")
	private Data2RedisThread(){
		
	}
	
	public Data2RedisThread(List<String> list, CountDownLatch countDownLatch){
		this.list = list;
		this.countDownLatch = countDownLatch;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public CountDownLatch getCountDownLatch() {
		return countDownLatch;
	}

	public void setCountDownLatch(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "-》开始运行");
		try {
			data2Redis(list);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			synchronized (locl_obj) {
				countDownLatch.countDown();
				System.out.println(Thread.currentThread().getName() + "-》剩余数量：" + countDownLatch.getCount());
			}
		}
	}
	
	private void data2Redis(List<String> list) throws Exception {
		for(String str : list){
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getName() + "->" + str);
		}
	}
	

}
