package com.ztw.thread.threadPool.job;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.ztw.thread.threadPool.ApplicationUtil;
import com.ztw.thread.threadPool.mapper.FundMapper;
import com.ztw.thread.threadPool.runnable.MoneyFund2RedisThread;

@Service
public class MoneyFund2RedisService {
	
	@Autowired
	private FundMapper fundMapper;
		
	private static final int pool_size = 10;
	
	private ExecutorService executorService = Executors.newFixedThreadPool(pool_size);
	
	public void execute() {
		List<Integer> innerCodeList = fundMapper.getAllMoneyFund();
		int i = (innerCodeList.size() % pool_size == 0) ? innerCodeList.size() / pool_size : innerCodeList.size() / pool_size + 1;
		List<List<Integer>> lists = Lists.partition(innerCodeList, i > pool_size ? i : pool_size);
		CountDownLatch countdown = new CountDownLatch(lists.size());
		for(List<Integer> list : lists){
			MoneyFund2RedisThread moneyFund2RedisThread = (MoneyFund2RedisThread) ApplicationUtil.getBean("moneyFund2RedisThread");
			moneyFund2RedisThread.setList(list);
			moneyFund2RedisThread.setCountDownLatch(countdown);
			executorService.execute(moneyFund2RedisThread);
		}
		
		try {
			countdown.await();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

}
