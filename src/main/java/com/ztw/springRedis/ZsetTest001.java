package com.ztw.springRedis;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisZSetCommands.Tuple;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;

public class ZsetTest001 extends BaseConnect {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	private static final String NewsInfo_Redis_Key = "newsInfo:";

	@Test
	public void test005() {
		//stringRedisTemplate.opsForValue().s
	}

//	public Long add(K key, Set<TypedTuple<V>> tuples) {
//		final byte[] rawKey = rawKey(key);
//		final Set<Tuple> rawValues = rawTupleValues(tuples);
//
//		return execute(new RedisCallback<Long>() {
//
//			public Long doInRedis(RedisConnection connection) {
//				return connection.zAdd(rawKey, rawValues);
//			}
//		}, true);
//	}

	@Test
	public void test004() {
		Set<String> set = stringRedisTemplate.keys("qcb:fc:stock_news");
		System.out.println(set);
	}

	@Test
	public void test003() {
		String redisKey = "newKey002";
		Set<String> set = stringRedisTemplate.opsForZSet().range(redisKey, 0, -1);

		System.out.println(set.size() + ":" + set);

		stringRedisTemplate.opsForZSet().removeRangeByScore(redisKey, Long.MIN_VALUE, 20170618);
		// stringRedisTemplate.opsForHash().putAll("", "");
	}

	@Test
	public void test001() {
		// String ztb_redis_key = NewsInfo_Redis_Key + "ztb";
		// String xjb_redis_key = NewsInfo_Redis_Key + "xjb";
		// List<String> redisKeys = Lists.newArrayList(ztb_redis_key,
		// xjb_redis_key);
		//
		// if(stringRedisTemplate.hasKey("newKey002")){
		// stringRedisTemplate.delete("newKey002");
		// }

		// stringRedisTemplate.opsForZSet().unionAndStore(ztb_redis_key,
		// xjb_redis_key, "newKey002");

		int pageNum = 2;
		int pageSize = 10;
		int offset = (pageNum - 1) * pageSize;

		Set<String> infoList = stringRedisTemplate.opsForZSet().reverseRangeByScore("newKey002", Long.MIN_VALUE,
				Long.MAX_VALUE, offset, 10);
		System.out.println(infoList);
	}

	@Test
	public void test() {
		List<NewsInfo> ztb_list = getList("涨停宝");
		List<NewsInfo> xjb_list = getList("现金宝");

		String ztb_redis_key = NewsInfo_Redis_Key + "ztb";
		String xjb_redis_key = NewsInfo_Redis_Key + "xjb";

		init(ztb_list, ztb_redis_key);
		init(xjb_list, xjb_redis_key);
	}

	public void init(List<NewsInfo> list, String redisKey) {
		if (stringRedisTemplate.hasKey(redisKey)) {
			stringRedisTemplate.delete(redisKey);
		}
		list.forEach(e -> data2Redis(e, redisKey));
	}

	/**
	 * 将数据存入Redis
	 * 
	 * @param record
	 */
	private void data2Redis(NewsInfo record, String redisKey) {
		double score = Double.parseDouble(record.getTime().replace("-", ""));
		String str = JSON.toJSONString(record, SerializerFeature.WriteMapNullValue);
		stringRedisTemplate.opsForZSet().add(redisKey, str, score);
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
