package com.ztw.timeUtil;


import org.junit.Test;

public class TimeUtilTest {
	
	@Test
	public void test000(){
		System.out.println("*****");
	}

	@Test
	public void test001(){
		String now = TimeUtil.getCurrentDatetime();
		System.out.println(now);
	}
}
