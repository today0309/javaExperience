package com.ztw.javaBase;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class Test001 {

	public static int a = 50;
	
	public int b = 50;
	
	
	@Test
	public void test002(){
		Map<String, String> map = new ConcurrentHashMap<String, String>();
		map.put("123", null);
	}

	@Test
	public void test000(){
		
		String str1 = "hello";
		String str2 = " world";
		String str3 = str1 + str2;
		String str4 = "hello world";
		String str5 = new String("hello world");
		String str6 = new String("hello world");
		String str7 = "hello world";
		System.out.println(str3 == str7);
	}
	
	@Test
	public void test001(){
		System.out.println("当前a=" + a);
		System.out.println("当前b=" + b);
		a--;
		b--;
	}
	
	
}
