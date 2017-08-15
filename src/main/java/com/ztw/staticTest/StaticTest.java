package com.ztw.staticTest;

public class StaticTest {
	
	static int a;

	static{
		System.out.println("最先执行");
		a = 8;
	}
	
	public void test(){
		System.out.println("自定义方法:" + a);
	}
	
	static{
		System.out.println("第二次执行执行");
	}
	
	public static void main(String[] args) {
		StaticTest staticTest = new StaticTest();
		staticTest.test();
	}
}
