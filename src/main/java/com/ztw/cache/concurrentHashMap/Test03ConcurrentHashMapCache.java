package com.ztw.cache.concurrentHashMap;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


/**
 * 线程T1或者线程T2访问cacheMap，如果都没有时，这时执行了FutureTask来完成异步任务，
 * 假如线程T1执行了FutureTask，并把保存到ConcurrentHashMap中，通过PutIfAbsent方法，
 * 因为putIfAbsent方法如果不存在key对应的值，则将value以key加入Map，否则返回key对应的旧值。
 * 这时线程T2进来时可以获取Future对象，如果没值没关系，这时是对象的引用，等FutureTask执行完，在通过get返回。
 * @author Administrator
 *
 * @param <K>
 * @param <V>
 */
public class Test03ConcurrentHashMapCache<K, V> {
	
	private final ConcurrentHashMap<K, Future<V>> cacheMap = new ConcurrentHashMap<K, Future<V>>();

	public Object getCache(K keyValue, String ThreadName) {
		Future<V> value = null;
		try {
			System.out.println("ThreadName getCache==============" + ThreadName);
			// 从缓存获取数据
			value = cacheMap.get(keyValue);
			// 如果没有的话，把数据放到缓存
			if (value == null) {
				value = putCache(keyValue, ThreadName);
				return value.get();
			}
			return value.get();

		} catch (Exception e) {
		}
		return null;
	}

	public Future<V> putCache(K keyValue, final String ThreadName) {
		// //把数据放到缓存
		Future<V> value = null;
		Callable<V> callable = new Callable<V>() {
			@SuppressWarnings("unchecked")
			@Override
			public V call() throws Exception {
				// 可以根据业务从数据库获取等取得数据,这边就模拟已经获取数据了
				System.out.println("ThreadName 执行业务数据并返回处理结果的数据（访问数据库等）==============" + ThreadName);
				return (V) "dataValue";
			}
		};
		FutureTask<V> futureTask = new FutureTask<V>(callable);
		value = cacheMap.putIfAbsent(keyValue, futureTask);
		if (value == null) {
			value = futureTask;
			futureTask.run();
		}
		return value;
	}

	public static void main(String[] args) {
		final Test03ConcurrentHashMapCache<String, String> TestGuaVA = new Test03ConcurrentHashMapCache<String, String>();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {

				System.out.println("T1======start========");
				Object value = TestGuaVA.getCache("key", "T1");
				System.out.println("T1 value==============" + value);
				System.out.println("T1======end========");

			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("T2======start========");
				Object value = TestGuaVA.getCache("key", "T2");
				System.out.println("T2 value==============" + value);
				System.out.println("T2======end========");

			}
		});

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("T3======start========");
				Object value = TestGuaVA.getCache("key", "T3");
				System.out.println("T3 value==============" + value);
				System.out.println("T3======end========");

			}
		});

		t1.start();
		t2.start();
		t3.start();

	}

}
