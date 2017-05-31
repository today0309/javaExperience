package com.ztw.proxy;

public class Main {

	public static void main(String[] args) {
		DynamicSubject dynamicSubject = new DynamicSubject();
		Subject sub = (Subject) dynamicSubject.bind(new RealSubject());
		sub.doSomething();
	}

}
