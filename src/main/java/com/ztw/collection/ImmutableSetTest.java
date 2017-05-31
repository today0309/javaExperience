package com.ztw.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;

public class ImmutableSetTest {
	
	@Test
	public void test000(){
		System.out.println("*****");
	}
	
	@Test
	public void test002(){
		List<String> list = new ArrayList<>();
		for(int i=0; i<10; i++){
			list.add(String.valueOf(i));
		}
		ImmutableSet<String> strSet = ImmutableSet.copyOf(list);
		List<String> list1 = Collections.unmodifiableList(list);
		System.out.println(strSet);
		System.out.println(list1);
		list.add("11");
		System.out.println(strSet);//数据不变
		System.out.println(list1);//增加一条数据，与list一致
	}
	
	

	@Test
	public void test001() {
		
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println(list);

		List<String> unmodifiableList = Collections.unmodifiableList(list);
		System.out.println(unmodifiableList);

		List<String> unmodifiableList1 = Collections.unmodifiableList(Arrays.asList("a", "b", "c"));
		System.out.println(unmodifiableList1);

		String temp = unmodifiableList.get(1);
		System.out.println("unmodifiableList [0]：" + temp);

		list.add("baby");
		System.out.println("list add a item after list:" + list);
		System.out.println("list add a item after unmodifiableList:" + unmodifiableList);

		try {
			unmodifiableList1.add("bb");
			System.out.println("unmodifiableList add a item after list:" + unmodifiableList1);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			unmodifiableList.add("cc");
			System.out.println("unmodifiableList add a item after list:" + unmodifiableList);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
