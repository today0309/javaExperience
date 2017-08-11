package com.ztw.springRedis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

public class RedisTest001 extends BaseConnect {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	private static final String redis_key = "key001";
	
	@Test
	public void test(){
		String tempKey = redis_key + "Temp";
		//stringRedisTemplate.delete(tempKey);
		//stringRedisTemplate.opsForValue().set(tempKey, "asdfgTEMP");
		stringRedisTemplate.rename(tempKey, redis_key);
	}
	
}
