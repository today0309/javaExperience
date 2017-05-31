package com.ztw.thread.threadPool.test;

import java.util.Set;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.ztw.thread.threadPool.job.Data2RedisService;
import com.ztw.thread.threadPool.job.MoneyFund2RedisService;

public class Date2RedisTest extends BaseTest{
	
	@Autowired
	private Data2RedisService data2RedisService;
	
	@Autowired
	private MoneyFund2RedisService moneyFund2RedisService;
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	public Set<String> getAllKey(String head) {
		try {
			return redisTemplate.keys(head + "*");
		} catch (Exception e) {
			System.out.println("get redis all keys失败:" + e);
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void test003(){
		System.out.println(getAllKey(""));
	}
	
	@Test
	public void test002(){
		String str = redisTemplate.opsForValue().get("fund:money:2410");
		System.out.println(str);
	}
	
	@Test
	public void test001(){
		try {
			moneyFund2RedisService.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Test
	public void test000(){
		data2RedisService.execute();
	}
}
