package com.ztw.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class Stream_map {
	
	private List<String> list;
	
	@Test
	public void test000(){
		System.out.println(Integer.MAX_VALUE);
	}
	
	/**
	 * 给定一个Integer类型的List，
	 * 获取其对应的Stream对象，
	 * 然后进行过滤掉null，
	 * 再去重，
	 * 再每个元素乘以2，
	 * 再每个元素被消费的时候打印自身，
	 * 在跳过前两个元素，
	 * 最后去前四个元素进行加和运算
	 */
	@Test
	public void test(){
		
		List<Integer> nums = Lists.newArrayList(1 , 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10, 11, 12);
		//System.out.println(
				nums
				.stream()
				.filter(num -> num != null)
				.distinct()
				.mapToInt(num -> num * 2)
				.peek(System.out::println)
				.skip(2)
				.limit(5).sum();
		//		);
	}
	
	
	@Test
	/**
	 * map 生成的是个 1:1 映射，每个输入元素，都按照规则转换成为另外一个元素。
	 */
	public void map(){
		
		System.out.println(list);
		List<String> newList = list.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(newList);
		System.out.println(list.stream().map(e->e + "#").collect(Collectors.toList()));
	}
	
	
	@Test
	public void flatMap(){
		Stream<List<Integer>> inputStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
		Stream<Integer> outputStream = inputStream.flatMap((childList) -> childList.stream());
	    outputStream.forEach(e->System.out.println(e));
	}
	
	
	
	@Before
	public void setList(){
		list = Lists.newArrayList("a", "D", "f", "r", "z");
	}

}
