package com.ztw.springRedis;

import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

public class HX_Redis_Test extends BaseConnect {

	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Autowired
	private RedisService redisService;
	
	private static String redisKey = "qcb:moneyFund:avgLatestweeklyyield:*";
	
	@Test
	public void test002(){
		Set<String> set = redisService.getAllKey(redisKey);
		System.out.println(set);
	}
	
	@Test
	public void test001(){
		try {
			
			redisService.delAllKey(redisKey);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	@Test
	public void test000(){
		try {
			String redisKey = "qcb:moneyFund:avgLatestweeklyyield";
			System.out.println(redisTemplate.hasKey(redisKey));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
