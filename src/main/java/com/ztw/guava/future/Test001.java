package com.ztw.guava.future;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class Test001 {
	
	ExecutorService threadPool = Executors.newCachedThreadPool();
	
	ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
	
	@Test
	public void guavaFuture() throws Exception {
		ListenableFuture<String> future = executorService.submit(new MyCallable(3000));
		Futures.addCallback(future, new FutureCallback<String>() {

			@Override
			public void onSuccess(String result) {
				System.out.println(sdf.format(new Date()) + ": 获取结果为：" + result);
			}

			@Override
			public void onFailure(Throwable t) {
				System.out.println(t);
				System.out.println(sdf.format(new Date()) + ": 任务执行失败");
			}

		});
		System.out.println(sdf.format(new Date()) + " 开始运行别的了，啦啦。。。");
		for(int i=0; i<10; i++){
			System.out.println("别的程序正在运行中......" + i);
			Thread.sleep(1000);
		}
	}
	
	@Test
	public void jdkFuture() throws Exception {
		Future<String> future = threadPool.submit(new MyCallable(5000));
		System.out.println(sdf.format(new Date()) + " 是否完成 : " + future.isDone());
		System.out.println(sdf.format(new Date()) + " 运行结果: " + future.get());
		System.out.println(sdf.format(new Date()) + " 是否完成: " + future.isDone());
		System.out.println(sdf.format(new Date()) + " 开始运行别的了，啦啦。。。");
	}

	@Test
	public void test000() throws Exception {
		Future<String> future = threadPool.submit(new MyCallable(5000));
		System.out.println(sdf.format(new Date()) + "is B done : " + future.isDone());
		try {
			System.out.println(sdf.format(new Date()) + "result of B : " + future.get(3000, TimeUnit.MILLISECONDS));//阻塞线程
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println(sdf.format(new Date()) + "is B done : " + future.isDone());
	}
}
