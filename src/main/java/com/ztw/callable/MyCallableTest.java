package com.ztw.callable;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.common.collect.Lists;

public class MyCallableTest {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		int taskSize = 10;
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		// 创建多个有返回值的任务
		List<Future> list = Lists.newArrayList();
		for (int i = 0; i < taskSize; i++) {
			// 执行任务并获取Future对象
			Future f = pool.submit(new MyCallable(i + " "));
			list.add(f);
		}
		// 关闭线程池
		pool.shutdown();
		// 获取所有并发任务的运行结果
		for (Future f : list) {
			// 从Future对象上获取任务的返回值，并输出到控制台
			System.out.println(">>>" + f.get().toString());
		}
	}
	
}
