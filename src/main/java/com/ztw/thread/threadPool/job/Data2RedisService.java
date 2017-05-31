package com.ztw.thread.threadPool.job;

import java.util.List;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.ztw.thread.threadPool.runnable.Data2RedisThread;


@Service
public class Data2RedisService {
	
	private static final int pool_size = 7;
	
	private ExecutorService executorService = Executors.newFixedThreadPool(pool_size);

	public void execute() {
		List<String> taskList = getList();
		int i = (taskList.size() % pool_size == 0) ? taskList.size() / pool_size : taskList.size() / pool_size + 1;
		List<List<String>> lists = Lists.partition(getList(), i > pool_size ? i : pool_size);
		CountDownLatch countdown = new CountDownLatch(lists.size());
		for(List<String> list : lists){
			Data2RedisThread data2RedisThread = new Data2RedisThread(list, countdown);
			executorService.execute(data2RedisThread);
		}
		
		try {
			countdown.await();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		
	}
	
	public List<String> getList(){
		List<String> list = Lists.newArrayList();
		String str;
		for(int i=1000; i<1100; i++){
			str = "A".concat("_").concat(String.valueOf(i));
			list.add(str);
		}
		return list;
	}
	
}
