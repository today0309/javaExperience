package com.ztw.javaBase;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RemoveList {

	@Test
	public void test001() {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(String.valueOf(i));
		}
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("3")) {
				list.remove(i);
				i--;
			}
		}
		System.out.println(list);
	}
}
