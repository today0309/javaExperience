package com.ztw.springRedis;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;

import com.google.common.collect.Lists;

import io.netty.util.internal.StringUtil;

public class ZsetTest002 extends BaseConnect {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Test
	public void test002(){
//		List<String> list = Lists.newArrayList("a", "b", "c", "d");
//		String str = StringUtils.join(list, "-");
//		System.out.println(str);
		try {
			stringRedisTemplate.delete("20170710");
			System.out.println("删除成功");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void test001() {

		Set<TypedTuple<String>> set = stringRedisTemplate.opsForZSet().reverseRangeByScoreWithScores("newKey002",
				Long.MIN_VALUE, Long.MAX_VALUE, 0, 10);
		Iterator<TypedTuple<String>> iterator = set.iterator();
		while(iterator.hasNext()){
			TypedTuple<String> t = iterator.next();
			System.out.println(t.getValue());
			System.out.println(t.getScore().doubleValue());
		}
		
		TypedTuple<String> typedTuple1 = new DefaultTypedTuple<String>("zset-5",Double.valueOf("9.6"));
		TypedTuple<String> typedTuple2 = new DefaultTypedTuple<String>("zset-6",9.5);
		
		Set<TypedTuple<String>> set001 = new HashSet<>();
		set001.add(typedTuple1);
		set001.add(typedTuple2);
		
		stringRedisTemplate.opsForZSet().add("newKey002", set001);
		
	}

}
