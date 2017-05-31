package com.ztw.thread.threadPool.runnable;

import java.math.BigDecimal;


import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ztw.thread.threadPool.mapper.FundMapper;


@Component
@Scope("prototype")
public class MoneyFund2RedisThread implements Runnable {
	
	private List<Integer> list;

	private CountDownLatch countDownLatch;

	private static Object locl_obj = new Object();
	
	private static String redis_key = "fund:money:";
	
	@Autowired
	private FundMapper fundaMapper;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public void run() {
		try {
			data2Redis(list);
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			synchronized (locl_obj) {
				countDownLatch.countDown();
			}
		}
		
	}
	
	public void data2Redis(List<Integer> list){
		for(Integer innerCode : list){
			BigDecimal value = fundaMapper.getAvgLatestWeeklyYieldByInnerCode(innerCode);
			String redisKey = redis_key + innerCode;
			String redisValue = JSON.toJSONString(value, SerializerFeature.WriteMapNullValue);
			redisTemplate.opsForValue().set(redisKey, redisValue);
			System.out.println(Thread.currentThread().getName() + "#####" + redisKey + "=》存入Redis成功");
		}
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public CountDownLatch getCountDownLatch() {
		return countDownLatch;
	}

	public void setCountDownLatch(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}
	
	

}
