package com.ztw.springRedis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

public class SetTest extends BaseConnect {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Test
	public void test000(){
		//stringRedisTemplate.opsForSet().add("setKet", "setValues01", "setValues02");
		
		System.out.println(stringRedisTemplate.opsForSet().isMember("setKet", "asd"));
		System.out.println(stringRedisTemplate.opsForSet().isMember("setKet", "setValues01"));
	}
	
	public static void main(String[] args) {
		char[] c1 = {'a', 'b', 'c'};
		char[] c2 = c1;
		c1[1] = 'x';
		System.out.println(c1);
		System.out.println(c2);
	}
	
	
}
