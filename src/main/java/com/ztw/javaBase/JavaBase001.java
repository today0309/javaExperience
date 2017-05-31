package com.ztw.javaBase;

import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;

/**
 * JAVA基础功能
 * 
 * @author Administrator
 *
 */
public class JavaBase001 {
	
	@Test
	public void test005(){
		String stockCodes = "221,123,321,111,3333,dea,ad,221";
		final ImmutableSet<String> stockCodesSet = ImmutableSet.<String> builder().add(stockCodes.split(",")).build();
		System.out.println(stockCodesSet);
	}

	@Test
	public void test000() {
		System.out.println("*****");
	}

	/**
	 * 拆分器 【Splitter】
	 */
	@Test
	public void test001() {
		String str = ",a,,b,";
		String[] array = str.split(",");
		int i = 0;
		System.out.println("*****");
		while (i < array.length) {
			System.out.println(array[i++]);
		}
		System.out.println("*****");

		Iterable<String> iterable = Splitter.on(',').trimResults().omitEmptyStrings().split(str);
		iterable.forEach(System.out::println);
	}
	
	
	/**
	 * 参数个数不确定的时候用 ... 来代替
	 */
	@Test
	public void test002() {
		String str = format("ztw", "01", "02", null);
		System.out.println(str);
	}

	public String format(String... args) {
		int i = 1;
		while (i < args.length) {
			args[0] += args[i++];
		}
		return args[0];
	}
	
	
	
	
}
