package com.ztw.guava.guavaCache;


import org.junit.Test;


public class GuavaCacheTest {
	
	/**
	 * 从缓存中读取我们需要数据，如果数据不存在就读取数据存入缓存
	 */
	@Test
	public void test002(){
		System.out.println(GuavaCacheUtil.getMap());
		System.out.println(GuavaCacheUtil.getMap());
	}

	@Test
	public void test001() throws Exception{
		GuavaCacheUtil.put("key001", "value001");
		String str01 = (String) GuavaCacheUtil.get("key001");
		System.out.println(str01);
		String str02 = (String) GuavaCacheUtil.get1("key001");
		System.out.println(str02);
		Thread.sleep(1000 * 60);
		String str03 = (String) GuavaCacheUtil.get1("key001");
		System.out.println(str03);
	}
}
