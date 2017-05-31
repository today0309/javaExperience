package com.ztw.guava.immutable;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;


/**
 * Immutable集合使用方法：
　　一个immutable集合可以有以下几种方式来创建：
　　1.用copyOf方法, 譬如, ImmutableSet.copyOf(set)
　　2.使用of方法，譬如，ImmutableSet.of("a", "b", "c")或者ImmutableMap.of("a", 1, "b", 2)
　　3.使用Builder类
 * @author Administrator
 *
 */
public class GuavaImmutableTest {

	@Test
	public void testGuavaImmutable() {

		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println("list：" + list);

		ImmutableList<String> imlist = ImmutableList.copyOf(list);
		System.out.println("imlist：" + imlist);

		ImmutableList<String> imOflist = ImmutableList.of("peida", "jerry", "harry");
		System.out.println("imOflist：" + imOflist);

		ImmutableSortedSet<String> imSortList = ImmutableSortedSet.of("a", "b", "c", "a", "d", "b");
		System.out.println("imSortList：" + imSortList);

		list.add("baby");
		System.out.println("list add a item after list:" + list);
		System.out.println("list add a item after imlist:" + imlist);

		ImmutableSet<Color> imColorSet = ImmutableSet.<Color> builder().add(new Color(0, 255, 255))
				.add(new Color(0, 191, 255)).build();

		System.out.println("imColorSet:" + imColorSet);
	}

}
