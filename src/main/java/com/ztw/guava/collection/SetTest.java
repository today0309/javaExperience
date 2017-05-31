package com.ztw.guava.collection;

import java.util.Set;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;

public class SetTest {

	@Test
	public void test000() {
		System.out.println("****");
	}

	/**
	 * 求两个集合的交集
	 */
	@Test
	public void test001() {
		Set<String> wordsWithPrimeLength = ImmutableSet.of("one", "two", "three", "six", "seven", "eight");
		Set<String> primes = ImmutableSet.of("two", "three", "five", "seven");
		SetView<String> intersection = Sets.intersection(primes, wordsWithPrimeLength);
		System.out.println(intersection.immutableCopy());// 可以使用交集，但不可变拷贝的读取效率更高
	}

	/**
	 * 把字符串按长度分组
	 * 
	 */
	@Test
	public void test002() {
		ImmutableSet<String> digits = ImmutableSet.of("no", "zero", "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine");
		Function<String, Integer> lengthFunction = new Function<String, Integer>() {
			public Integer apply(String string) {
				return string.length();
				//return string.hashCode();
			}
		};
		ImmutableListMultimap<Integer, String> digitsByLength = Multimaps.index(digits, lengthFunction);
		System.out.println(digitsByLength);
	}

}
