package com.ztw.guava.immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * 在JDK中提供了Collections.unmodifiableXXX系列方法来实现不可变集合, 但是存在一些问题
 * 
 * @author Administrator
 *
 */
public class JdkImmutableTest {
	
	
	/**
	 * Collections.unmodifiableList实现的不是真正的不可变集合，当原始集合修改后，不可变集合也发生变化。
	 * 不可变集合不可以修改集合数据，当强制修改时会报错，实例中的最后两个add会直接抛出不可修改的错误。
	 */
	@Test
	public void testJDKImmutable() {
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

		unmodifiableList1.add("bb");
		System.out.println("unmodifiableList add a item after list:" + unmodifiableList1);

		unmodifiableList.add("cc");
		System.out.println("unmodifiableList add a item after list:" + unmodifiableList);
	}
}
