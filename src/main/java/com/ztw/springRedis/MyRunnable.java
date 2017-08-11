package com.ztw.springRedis;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyRunnable implements Runnable{
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	private static String redisKey = "myRedisKey";

	@Override
	public void run() {
		try {
			Set<String> rerurnStr = stringRedisTemplate.opsForZSet().rangeByScore(redisKey, 0, 5);
			System.out.println(rerurnStr);
		} catch (Exception e) {
			System.out.println("###########异常########");
			System.out.println(e);
		}
		
	}

}
