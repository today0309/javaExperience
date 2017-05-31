package com.ztw.thread.futureTask;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

	private long waitTime;

	public MyCallable(int timeInMillis) {
		this.waitTime = timeInMillis;
	}

	@Override
	public String call() throws Exception {
		String result = Thread.currentThread().getName();
		System.out.println(result + "==》start");
		Thread.sleep(waitTime);
		System.out.println(result + "==》end");
		return result;
	}

}
