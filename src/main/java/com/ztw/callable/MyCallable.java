package com.ztw.callable;

import java.util.concurrent.Callable;

import org.springframework.util.StopWatch;

public class MyCallable implements Callable<Object> {

	private String taskNum;

	public MyCallable(String taskNum) {
		this.taskNum = taskNum;
	}

	@Override
	public Object call() throws Exception {
		System.out.println(">>>" + taskNum + "任务启动");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Thread.sleep(1000);
		stopWatch.stop();
		System.out.println(">>>" + taskNum + "任务终止");
		return taskNum + "任务返回运行结果,当前任务时间【" + stopWatch.getTotalTimeMillis() + "毫秒】";
	}

}
