package com.ztw.springRedis;

import java.util.Iterator;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class RedisService {

	private static final Logger log = LoggerFactory.getLogger(RedisService.class);

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	/**
	 * 删除当前目录下所有的key
	 * 
	 * @param head
	 *            (如head=as:token删除所有的token缓存)
	 * @return
	 */
	public void delAllKey(String head) {
		try {
			Set<String> keys = getAllKey(head);
			Iterator<String> it = keys.iterator();
			while (it.hasNext()) {
				String key = (String) it.next();
				// 删除key
				del(key);
			}
		} catch (Exception e) {
			log.error("del redis all keys失败:" + head, e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取当前目录下所有的key
	 * 
	 * @param head
	 * @return
	 */
	public Set<String> getAllKey(String head) {
		try {
			return stringRedisTemplate.keys(head + "*");
		} catch (Exception e) {
			log.error("get redis all keys失败:" + head, e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 删除key
	 * 
	 * @param key
	 */
	public void del(String key) {
		try {
			stringRedisTemplate.delete(key);
		} catch (Exception e) {
			log.error("删除redis 失败:" + key, e);
			throw new RuntimeException(e);
		}
	}

}
