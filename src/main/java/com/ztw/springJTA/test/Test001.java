package com.ztw.springJTA.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ztw.springJTA.common.GlobalConfig;

public class Test001 extends BaseTest{

	@Autowired
	private GlobalConfig globalConfig;
	
	@Test
	public void test000(){
		System.out.println("************");
	}
	
	@Test
	public void test001(){
		System.out.println(globalConfig);
	}
	
}
