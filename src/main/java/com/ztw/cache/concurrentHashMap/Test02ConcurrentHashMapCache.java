package com.ztw.cache.concurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;


/**
 * 这样就实现了串行，在高并发行时，就不会出现了第二个访问相同业务，肯定是从缓存获取，
 * 但是加上Synchronized变成串行，这样在高并发行时性能也下降了。
 * 
 * @author Administrator
 *
 * @param <K>
 * @param <V>
 */
public class Test02ConcurrentHashMapCache<K, V> {

	private final ConcurrentHashMap<K, V> cacheMap = new ConcurrentHashMap<K, V>();

	public synchronized Object getCache(K keyValue, String ThreadName) {
		System.out.println("ThreadName getCache==============" + ThreadName);
		Object value = null;
		// 从缓存获取数据
		value = cacheMap.get(keyValue);
		// 如果没有的话，把数据放到缓存
		if (value == null) {
			return putCache(keyValue, ThreadName);
		}
		return value;
	}

	public Object putCache(K keyValue, String ThreadName) {
		System.out.println("ThreadName 执行业务数据并返回处理结果的数据（访问数据库等）==============" + ThreadName);
		// 可以根据业务从数据库获取等取得数据,这边就模拟已经获取数据了
		@SuppressWarnings("unchecked")
		V value = (V) "dataValue";
		// 把数据放到缓存
		cacheMap.put(keyValue, value);
		return value;
	}

	public static void main(String[] args) {
		
		final Test02ConcurrentHashMapCache<String, String> TestGuaVA = new Test02ConcurrentHashMapCache<String, String>();

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
