package com.ztw.guava.future;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

	private long waitTime;

	public MyCallable(int timeInMillis) {
		this.waitTime = timeInMillis;
	}

	@Override
	public String call() throws Exception {
		//String result = Thread.currentThread().getName();
		//System.out.println(sdf.format(new Date()) + " ： " + result + "==》start");
		Thread.sleep(waitTime);
		//System.out.println(sdf.format(new Date()) + " ： " + result + "==》end");
		throw new Exception("出现异常");
		//return result;
	}

}
