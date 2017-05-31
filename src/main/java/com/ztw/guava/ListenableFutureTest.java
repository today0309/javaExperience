package com.ztw.guava;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class ListenableFutureTest {

	/**
	 * Executors.newCachedThreadPool()；
	 * 创建corePoolSize为0，最大线程数为整型的最大数，线程keepAliveTime为1分钟，
	 * 缓存任务的队列为SynchronousQueue的线程池。
	 * 
	 * 1、首先通过MoreExecutors类的静态方法listeningDecorator方法初始化一个ListeningExecutorService的方法，
	 */
	ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

	
	/**
	 * 2、然后使用此实例的submit方法即可初始化ListenableFuture对象。
	 * 有了ListenableFuture实例，有两种方法可以执行此Future并执行Future完成之后的回调函数。
	 */
	final ListenableFuture<Integer> listenableFuture = executorService.submit(new Callable<Integer>() {
		@Override
		public Integer call() throws Exception {
			System.out.println(new Date() + "：call execute...");
			Thread.sleep(2000);
			System.out.println(new Date() + "：execute end...");
			return 7;
		}
	});

	@Test
	public void test000() throws Exception{
		test002();
	}
	
	/**
	 * 
	 * 方法一：通过ListenableFuture的addListener方法
	 */
	public void test001() {
		listenableFuture.addListener(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("get listenable future's result " + listenableFuture.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}, executorService);
	}

	public void test002() throws Exception {
		Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
			@Override
			public void onSuccess(Integer result) {
				System.out.println("get listenable future's result with callback " + result);
			}

			@Override
			public void onFailure(Throwable t) {
				t.printStackTrace();
				System.out.println(t);
			}
		});
		Thread.sleep(5000);
	}
	
/**
 * 推荐使用第二种方法，因为第二种方法可以直接得到Future的返回值，或者处理错误情况。本质上第二种方法是通过调动第一种方法实现的，做了进一步的封装。
 * 另外ListenableFuture还有其他几种内置实现：
 * SettableFuture：不需要实现一个方法来计算返回值，而只需要返回一个固定值来做为返回值，可以通过程序设置此Future的返回值或者异常信息
 * CheckedFuture： 这是一个继承自ListenableFuture接口，他提供了checkedGet()方法，此方法在Future执行发生异常时，可以抛出指定类型的异常。
 */
	
}
