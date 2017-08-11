package com.ztw.springRedis;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class RedisTransaction extends BaseConnect {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	
	@Test
	public void test002() throws Exception{
		String redisKey = "myRedisKey";
		List<NewsInfo> list = getList("ztw_0708");
		Set<TypedTuple<String>> set = Sets.newHashSet();
		for (int i = 0; i < list.size(); i++) {
			String str = JSON.toJSONString(list.get(i), SerializerFeature.WriteMapNullValue);
			TypedTuple<String> typedTuple = new DefaultTypedTuple<String>(str, Double.valueOf(i));
			set.add(typedTuple);
		}
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("开始插入操作");
					stringRedisTemplate.multi();
					stringRedisTemplate.delete(redisKey);
					System.out.println("发送删除命令");
					Thread.sleep(11 * 1000);
					stringRedisTemplate.opsForZSet().add(redisKey, set);
					//stringRedisTemplate.dm
//					stringRedisTemplate.watch(redisKey);
//					Thread.sleep(11 * 1000);
//					stringRedisTemplate.opsForZSet().add(redisKey, set);
//					Thread.sleep(3 * 1000);
//					stringRedisTemplate.unwatch();
					stringRedisTemplate.exec();
					System.out.println("插入操作结束");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		Thread.sleep(5 * 1000);
		new Thread(new Runnable() {
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
		}).start();
		
		Thread.sleep(5 * 1000);
		new Thread(new Runnable() {
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
		}).start();
		
		Thread.sleep(5 * 1000);
		new Thread(new Runnable() {
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
		}).start();
		
		Thread.sleep(5 * 1000);
		new Thread(new Runnable() {
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
		}).start();
		
		while(true){
			try {
				Thread.sleep(20 * 1000);
				System.out.println("********************");
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
	}

	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void test001(){
		List<NewsInfo> list = getList("ztw_0707");
		Set<TypedTuple<String>> set = Sets.newHashSet();
		for (int i = 0; i < list.size(); i++) {
			String str = JSON.toJSONString(list.get(i), SerializerFeature.WriteMapNullValue);
			TypedTuple<String> typedTuple = new DefaultTypedTuple<String>(str, Double.valueOf(i));
			set.add(typedTuple);
		}
//		stringRedisTemplate.delete("myKey");
//		stringRedisTemplate.opsForZSet().add("myKet", set);
		Map<String, String> map = Maps.newHashMap();
		map.put("key001", "value001");
		map.put("key002", "value002");
		map.put("key003", "value003");
		SessionCallback<Object> sessionCallback = new SessionCallback<Object>(){
			@Override
			public Object execute(RedisOperations operations) throws DataAccessException {
				operations.multi();  
				operations.delete("test");
				//operations.opsForHash().putAll("test", map);
				operations.opsForZSet().add("test", set);
//				operations.opsForZSet().add("test", "value001", 1);
//				operations.opsForZSet().add("test", "value002", 2);
//				operations.opsForZSet().add("test", "value003", 3);
				//operations.opsForHash().put("test", "key001", "value001");
				operations.expire("test", 1, TimeUnit.HOURS);
				Object val=operations.exec();
				return val;
			}
		};
		try {
			Object obj = stringRedisTemplate.execute(sessionCallback); 
			System.out.println(obj.toString());
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public List<NewsInfo> getList(String str) {
		List<NewsInfo> list = Lists.newArrayList();
		for (int i = 1; i < 15; i++) {
			String title = str + i + "号公告文件";
			String time = DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now().minusDays(i));
			String source = "基金公司";
			String content = str + "公告";
			list.add(new NewsInfo(title, time, source, content));
		}
		return list;
	}
}
