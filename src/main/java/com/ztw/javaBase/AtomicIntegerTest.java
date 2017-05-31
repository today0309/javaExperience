package com.ztw.javaBase;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class AtomicIntegerTest {
	
	@Test
	public void test000() {
		System.out.println("*****");
	}

	@Test
	public void test001() {
		AtomicInteger ati = new AtomicInteger(0);
		System.out.println(ati.get());
		System.out.println(ati.incrementAndGet());
		System.out.println(ati.get());
	}
	
}
