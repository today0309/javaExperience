package com.ztw.springRedis;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;

public class ZsetTest extends BaseConnect {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	private List<NewsInfo> list = Lists.newArrayList();
	
	private static final String NewsInfo_Redis_Key = "newsInfo"; 
	
	
	@Test
	public void test(){
		String redisKey = "key001";
		stringRedisTemplate.opsForValue().set(redisKey, "value001");
		String result = stringRedisTemplate.opsForValue().get(redisKey);
		System.out.println(result);
	}
	
	
	/**
	 * 初始化操作，将所有的数据存入Redis
	 */
	@Test
	public void init(){
		if(stringRedisTemplate.hasKey(NewsInfo_Redis_Key)){
			stringRedisTemplate.delete(NewsInfo_Redis_Key);
		}
		list.forEach(e -> data2Redis(e));
	}
	
	
	/**
	 * 插入一条数据
	 */
	@Test
	public void set1NewsInfo(){
		//String title = "华夏银行16年财报";
		String title = "华夏银行2017年第一季度财报";
		String time = DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now());
		String source = "华夏银行";
		String content = "本年度财报信息如下：";
		NewsInfo record = new NewsInfo(title, time, source, content);
		data2Redis(record);
	}
	
	
	/**
	 * 分页查询，根据新闻发布日期降序
	 */
	@Test
	public void test001(){
		List<NewsInfo> list01 = queryByPage(2, 10);
		System.out.println(list01);
		//List<NewsInfo> list02 = queryByDate("2017-05-01", "2017-05-31");
		//System.out.println(list02);
	}
	
	
	/**
	 * 根据起始日期查询
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<NewsInfo> queryByDate(String startDate, String endDate){
		List<NewsInfo> list = Lists.newArrayList();
		double min = Double.parseDouble(startDate.replace("-", ""));
		double max = Double.parseDouble(endDate.replace("-", ""));
		Set<String> set = stringRedisTemplate.opsForZSet().rangeByScore(NewsInfo_Redis_Key, min, max);
		set.forEach(e -> list.add(JSON.parseObject(e, NewsInfo.class)));
		return list;
	}
	
	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<NewsInfo> queryByPage(int pageNum, int pageSize){
		List<NewsInfo> list = Lists.newArrayList();
		long start = (pageNum - 1) * pageSize;
		long end = pageNum * pageSize - 1;
		Set<String> set = stringRedisTemplate.opsForZSet().reverseRange(NewsInfo_Redis_Key, start, end);
		set.forEach(e -> list.add(JSON.parseObject(e, NewsInfo.class)));
		return list;
	}
	
	
	/**
	 * 将数据存入Redis
	 * @param record
	 */
	private void data2Redis(NewsInfo record){
		double score = Double.parseDouble(record.getTime().replace("-", ""));
		String str = JSON.toJSONString(record, SerializerFeature.WriteMapNullValue);
		stringRedisTemplate.opsForZSet().add(NewsInfo_Redis_Key, str, score);
	}
	
	@Before
	public void setList(){
		for(int i=1; i<165; i++){
			String title = "华夏基金" + i + "号公告文件";
			String time = DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now().minusDays(i));
			String source = "基金公司";
			String content = "华夏基金管理有限公司成立于1998年4月9日，是经中国证监会批准成立的全国性基金管理公司之一。";
			list.add(new NewsInfo(title, time, source, content));
		}
	}
	
}
