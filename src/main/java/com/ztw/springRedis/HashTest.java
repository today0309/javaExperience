package com.ztw.springRedis;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class HashTest extends BaseConnect {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Test
	public void test000(){
//		Map<String, String> map = Maps.newHashMap();
//		map.put("2017-07-01", "23.98");
//		map.put("2017-07-05", "21.98");
//		map.put("2017-07-02", "22.48");
//		map.put("2017-07-04", "23.02");
//		map.put("2017-07-03", "25.00");
//		stringRedisTemplate.opsForHash().putAll("quotation", map);
//		List<String> list = Lists.newArrayList("yangjie", "yanggang", "yangliang");
//		stringRedisTemplate.opsForList().rightPushAll("mimvip", list);
		stringRedisTemplate.rename("mimvip", "mimvp");
		//stringRedisTemplate.opsForValue().setBit(key, offset, value);
		//stringRedisTemplate.opsForValue().getBit("peter", offset)
		//stringRedisTemplate.opsForValue().
	}
	
}
