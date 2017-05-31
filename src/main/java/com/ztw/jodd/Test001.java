package com.ztw.jodd;

import org.junit.Test;

import jodd.bean.BeanUtil;


public class Test001 {

	@Test
	public void test000(){
		Foo foo = new Foo();
	    BeanUtil.pojo.setProperty(foo, "readwrite", "data");
	    BeanUtil.pojo.getProperty(foo, "readwrite");
	    BeanUtil.declared.setProperty(foo, "readonly", "data");
	}
}
