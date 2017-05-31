package com.ztw.javaBase;

import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.google.common.collect.Lists;


/**
 * http://www.cnblogs.com/ningvsban/p/3590722.html
 * @author Administrator
 *
 */
public class RandomTest {

	@Test
	public void test001(){
		List<Integer> list = Lists.newArrayList();
		Random random = new Random();
		int num = 10;
		while (num > 0) {
			num--;
			list.add(random.nextInt(10));
		}
		System.out.println(list);
	}
	
}
