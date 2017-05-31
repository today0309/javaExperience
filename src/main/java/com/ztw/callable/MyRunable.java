package com.ztw.callable;

import java.util.concurrent.CountDownLatch;

import org.springframework.util.StopWatch;

public class MyRunable implements Runnable {

	private String taskNum;
	
	private CountDownLatch countDownLatch;

	public MyRunable(String taskNum, CountDownLatch countDownLatch) {
		this.taskNum = taskNum;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		System.out.println(">>>" + taskNum + "任务启动");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		try {
			Thread.sleep(3000);
			if("4 ".equals(taskNum)){
				System.out.println("当前任务需加时...");
				Thread.sleep(1000 * 60);
			}
		} catch (InterruptedException e) {
			System.out.println(e);
		} finally{
			countDownLatch.countDown();
		}
		stopWatch.stop();
		
		System.out.println(">>>" + taskNum + "任务终止");
		System.out.println(taskNum + "任务执行完毕,耗时【" + stopWatch.getTotalTimeMillis() + "毫秒】");
	}

}
