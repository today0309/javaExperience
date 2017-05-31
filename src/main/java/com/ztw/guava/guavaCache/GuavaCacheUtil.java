package com.ztw.guava.guavaCache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * guava cache 的默认使用
 * 
 * @author zhongtongwei
 *
 */
public class GuavaCacheUtil {

	private static Cache<Object, Object> cache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.MINUTES)
			.build();

	private static Cache<String, Map<String, String>> map_cache = CacheBuilder.newBuilder()
			.expireAfterWrite(1, TimeUnit.MINUTES).build();

	private static Cache<String, List<String>> list_cache = CacheBuilder.newBuilder()
			.expireAfterWrite(1, TimeUnit.MINUTES).build();

	private static Cache<String, List<String>> list_cache_001 = CacheBuilder.newBuilder()
			.expireAfterWrite(1, TimeUnit.MINUTES).build(new CacheLoader<String, List<String>>() {
				@Override
				public List<String> load(String key) throws Exception {
					// TODO Auto-generated method stub
					return null;
				}
			});

	public static final String HK_SECU_MAIN_SUMMARY_MAP = "hkSecuMainSummaryMap";

	public static final String HK_SECU_MAIN_SUMMARY_LIST = "hkSecuMainSummaryList";

	public static List<String> getList() {
		List<String> list = Lists.newArrayList();
		if (0 == list_cache.size()) {// 如果此缓存中的条目的近似数量为0，则构建缓存。
			list.addAll(Lists.newArrayList("list001", "list002", "list003", "list004", "list005"));
			list_cache.put(HK_SECU_MAIN_SUMMARY_LIST, list);
		}
		list = list_cache.getIfPresent(HK_SECU_MAIN_SUMMARY_LIST);
		if (null == list || 0 == list.size()) {
			return getList();
		} else {
			return list;
		}
	}

	public static Map<String, String> getMap() {
		Map<String, String> map = Maps.newHashMap();
		try {
			map = map_cache.get(HK_SECU_MAIN_SUMMARY_MAP, new Callable<Map<String, String>>() {
				@Override
				public Map<String, String> call() throws Exception {
					System.out.println("缓存数据为空，将数据存入缓存");
					Map<String, String> map = Maps.newHashMap();
					map.put("key001", "value001");
					map.put("key002", "value002");
					map.put("key003", "value003");
					map.put("key004", "value004");
					map.put("key005", "value005");
					return map;
				}
			});
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return map;
	}

	public static Object get(Object key) throws ExecutionException {
		Object var = cache.get(key, new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				return key + "对应的value";
			}
		});
		return var;
	}

	public static void put(Object key, Object value) {
		cache.put(key, value);
	}

	public static Object get1(Object key) {
		Object var = cache.getIfPresent(key);
		return var;
	}

}
