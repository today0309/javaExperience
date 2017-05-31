package com.ztw.guava;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class ListenableFutureTest001 {

	public static void main(String[] args) throws InterruptedException {
		
		ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

		final ListenableFuture<String> future = pool.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("calling...");
				Thread.sleep(1000 * 2);
				return "Task done !";
			}
		});

		Futures.addCallback(future, new FutureCallback<String>() {
			@Override
			public void onSuccess(String result) {
				System.out.println("start call...");
				System.out.println(result);
			}

			@Override
			public void onFailure(Throwable t) {
				t.printStackTrace();
			}
		});

		Thread.sleep(5 * 1000); // wait for task done
		pool.shutdown();
	}
}
