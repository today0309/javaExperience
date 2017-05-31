package com.ztw.guava.collection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class ArrayListTest {

	@Test
	public void test000() {
		System.out.println("****");
	}

	/**
	 * Lists.partition(List<T> list, int i) 对List进行分割
	 */
	@Test
	public void test001() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 17; i++) {
			list.add(i);
		}
		System.out.println(list);
		List<List<Integer>> lists = Lists.partition(list, 5);
		System.out.println(lists);
	}
}
