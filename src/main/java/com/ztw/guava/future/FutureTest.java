package com.ztw.guava.future;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class FutureTest {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

	ExecutorService threadPool = Executors.newCachedThreadPool();
	
	ExecutorService threadPool01 = Executors.newFixedThreadPool(5);

	ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

	
	
	/**
	 * ListenableFuture顾名思义就是可以监听的Future，它是对java原生Future的扩展增强。
	 * 我们知道Future表示一个异步计算任务，当任务完成时可以得到计算结果。
	 * 如果我们希望一旦计算完成就拿到结果展示给用户或者做另外的计算，就必须使用另一个线程不断的查询计算状态。
	 * 这样做，代码复杂，而且效率低下。
	 * 使用ListenableFuture Guava帮我们检测Future是否完成了，如果完成就自动调用回调函数，这样可以减少并发程序的复杂度。
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void guavaFuture() throws Exception {
		ListenableFuture<String> listenableFuture = executorService.submit(new MyCallable(3000));
		System.out.println(sdf.format(new Date()) + ": 开始阻塞线程。。。");
		// String result = listenableFuture.get();
		// System.out.println(sdf.format(new Date()) + ": 获取结果为：" + result);
		Futures.addCallback(listenableFuture, new FutureCallback() {

			@Override
			public void onSuccess(Object result) {
				System.out.println(sdf.format(new Date()) + ": 获取结果为：" + result);
			}

			@Override
			public void onFailure(Throwable t) {
				System.out.println(t);
				System.out.println(sdf.format(new Date()) + ": 任务执行失败");
			}

		});
		executorService.shutdown();
		doSomething();
		
	}

	@Test
	public void jdkFuture() throws Exception {
		List<String> list = Lists.newArrayList();
		for(int i=0; i<5; i++){
			Future<String> future = threadPool.submit(new MyCallable(300));
			String result = future.get();
			list.add(result);
		}
		System.out.println(list);
		//System.out.println(sdf.format(new Date()) + ": 开始阻塞线程。。。");
		
		//System.out.println(sdf.format(new Date()) + ": 获取结果为：" + result);
	}
	
	private void doSomething() throws Exception{
		System.out.println(sdf.format(new Date()) + ": 开始做其它任务");
		Thread.sleep(5000);
		System.out.println(sdf.format(new Date()) + ": 其它任务执行完毕");
	}

}
