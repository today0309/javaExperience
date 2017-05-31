package com.ztw.guava.collection.ordering;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.util.StopWatch;

import com.google.common.collect.Ordering;

public class GetMaxNum {

	
	/**
	 * 比较两个获取List中最大值的方法性能
	 */
	@Test
	public void test001() {
		
		List<Integer> list = createList(10000000);
		
		StopWatch stopWatch01 = new StopWatch();
		stopWatch01.start();
		Integer max01 = getMax01(list);
		stopWatch01.stop();
		System.out.println("耗时：" + stopWatch01.getTotalTimeMillis() + "，取得最大值为：" + max01);
		
		StopWatch stopWatch02 = new StopWatch();
		stopWatch02.start();
		Integer max02 = getMax02(list);
		stopWatch02.stop();
		System.out.println("耗时：" + stopWatch02.getTotalTimeMillis() + "，取得最大值为：" + max02);
	}

	public static Integer getMax01(List<Integer> list) {
		int max = Ordering.natural().max(list);
		return max;
	}

	public static Integer getMax02(List<Integer> list) {
		int max = list.stream().max(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		}).get();
		return max;
	}

	public static List<Integer> createList(int num) {
		List<Integer> list = new ArrayList<>();
		Random random = new Random();
		while (num > 0) {
			num--;
			list.add(random.nextInt(100 * 100 * 100 * 10));
		}
		return list;
	}

}
