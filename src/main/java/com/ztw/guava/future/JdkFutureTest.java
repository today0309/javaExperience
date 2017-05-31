package com.ztw.guava.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 有两个任务A和B，A任务中仅仅需要使用B任务计算成果，有两种方法实现： A和B在同一个线程中顺序执行。即先执行B，得到返回结果之后再执行A。
 * 开两个线程，A和B并行执行。当A需要B的计算结果时如果B还没有执行完，A既可以选择阻塞等待B执行完，也可以先做其他的工作，过一段时间后再询问一次B。
 * 毫无疑问，如果B是一个耗时比较大的计算任务时，后者比前者的效率高了很多。
 * 
 * @author Administrator
 *
 */
public class JdkFutureTest {

	public static void main(String[] args) {

		ExecutorService threadPool = Executors.newCachedThreadPool();
		Future<Integer> future = threadPool.submit(new Callable<Integer>() {
			public Integer call() throws Exception {
				Thread.sleep(3000);
				return new Random().nextInt(100);
			}
		});

		doSomething();

		try {
			System.out.println("is B done : " + future.isDone());
			System.out.println("result of B : " + future.get());//阻塞线程
			System.out.println("is B done : " + future.isDone());
			int result = future.get();

			doSomethingWithB(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	private static void doSomethingWithB(int result) {
		// TODO Auto-generated method stub

	}

	private static void doSomething() {
		// TODO Auto-generated method stub

	}

}
