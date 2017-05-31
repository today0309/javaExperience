package com.ztw.thread.futureTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskExample3 {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
	
	private static int n = 0;
	
	public static void main(String[] args) throws Exception {
		
		MyCallable callable1 = new MyCallable(300);
		MyCallable callable2 = new MyCallable(400);

		FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
		FutureTask<String> futureTask2 = new FutureTask<String>(callable2);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(futureTask1);
		executor.execute(futureTask2);
		
		while(true){
			System.out.println(sdf.format(new Date()) + ": 开始循环第" + ++n + "次");
			if(futureTask1.isDone() && futureTask2.isDone()){
				String result1 = futureTask1.get();
				String result2 = futureTask2.get();
				System.out.println(sdf.format(new Date()) + ": 运行结果分别为：" + result1 + "和" + result2);
				executor.shutdown();
				System.out.println(sdf.format(new Date()) + ": 执行完毕，跳出循环。");
				return;
			}
			if(!futureTask1.isDone()){
				futureTask1.get();
				System.out.println(sdf.format(new Date()) + ": 任务1没有执行完毕");
			}
			if(!futureTask2.isDone()){
				futureTask2.get();
				System.out.println(sdf.format(new Date()) + ": 任务2没有执行完毕");
			}
		}
	}

}
