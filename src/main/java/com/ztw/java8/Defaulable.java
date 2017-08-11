package com.ztw.java8;

public interface Defaulable {

	static void staticMethod001() {
		System.out.println("这个是静态方法");
	}

	default void defaultMethod() {
		System.out.println("这个是默认的方法");
	}
	
	void method002();

}
