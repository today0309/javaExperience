package com.ztw.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.util.StopWatch;

public class ArrayListTest {

	@Test
	public void test000() {
		System.out.println("****");
	}

	/**
	 * 当一个List被分割之后，原始的List不可以进行修改
	 */
	@Test
	public void test001() {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(i);
		}
		List<Integer> list2 = list.subList(0, 3);
		System.out.println(list2);// [0, 1, 2]
		list.add(6);
		try {
			System.out.println(list);// [0, 1, 2, 3, 4, 6]
			System.out.println(list2);// java.util.ConcurrentModificationException
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 定义一个List的时候初始化大小，可以提升效率
	 */
	@Test
	public void test002() {
		List<Integer> list = new ArrayList<>();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		for (int i = 0; i < 1000000; i++) {
			list.add(i);
		}
		stopWatch.stop();
		System.out.println("耗时：" + stopWatch.getLastTaskTimeMillis());// 耗时：52

		List<Integer> list2 = new ArrayList<>(1000000);
		StopWatch stopWatch2 = new StopWatch();
		stopWatch2.start();
		for (int i = 0; i < 1000000; i++) {
			list2.add(i);
		}
		stopWatch2.stop();
		System.out.println("耗时：" + stopWatch2.getLastTaskTimeMillis());// 耗时：12
	}

	/**
	 * 1、int类型的数组与Integer类型数组转为List的区别 
	 * 
	 * 2、Arrays.asList()方法转变过来的list不可以进行add操作
	 */
	@Test
	public void test003() {
		int[] ints1 = { 1, 2, 3, 4, 5 };
		List<int[]> list1 = Arrays.asList(ints1);
		System.out.println(list1.size());// 1

		Integer[] ints2 = { 1, 2, 3, 4, 5 };
		List<Integer> list2 = Arrays.asList(ints2);
		System.out.println(list2.size());// 5
		try {
			list2.add(6);// java.lang.UnsupportedOperationException
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	@Test
	public void test004(){
		List<String> list = new ArrayList<>();
		int i = 0;
		while(i < 10){
			list.add(i + "a");
			i++;
		}
		System.out.println(list);
		list.remove(3);
		System.out.println(list);
		list.remove("6a");
		System.out.println(list);
	}

}
