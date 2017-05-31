package com.ztw.guava.collection.ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Ordering;

public class ListTest {

	@Test
	public void test000(){
		System.out.println("*****");
	}
	
	
	
	/**
	 * 取List中的最大值最小值
	 */
	@Test
	public void test001() {
		List<String> list = new ArrayList<>();
		list.add("2017-09-09");
		list.add("2018-01-02");
		list.add("2016-08-04");
		list.add("2014-05-17");
		list.add("2014-01-17");
		System.out.println("最小值为：" + Ordering.natural().min(list));
		System.out.println("最大值为：" + Ordering.natural().max(list));
		System.out.println("初始数据为：" + list);
		Collections.sort(list);
		System.out.println("使用Collections.sort()方法排序后的数据为：" + list);
	}
	
	
}
