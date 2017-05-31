package com.ztw.proxy;


/**
 * 定义真实角色,实现抽象角色
 * @author Administrator
 *
 */
public class RealSubject implements Subject {

	public void doSomething() {
		System.out.println("This is a RealSubject");
	}

}
