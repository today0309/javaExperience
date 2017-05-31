package com.ztw.collection;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.ztw.entity.UserInfo;

public class ParallelStream {

	@Test
	public void test001() throws Exception {
		List<UserInfo> list = getUserInfoList();
		Map<Integer, Integer> result = list.parallelStream().filter(p -> p.getAge() >= 25 && p.getAge() <= 35)
				.collect(Collectors.groupingBy(p -> p.getSex(), Collectors.summingInt(p -> 1)));
		System.out.println(result);
	}

	@Test
	public void test002() throws Exception {
		List<UserInfo> list = getUserInfoList();
		List<UserInfo> list2 = list.parallelStream().filter(p -> p.getAge() >= 25 && p.getAge() <= 30)
				.collect(Collectors.toList());
		list2.forEach(e -> System.out.println(e));
	}

	public List<UserInfo> getUserInfoList() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<UserInfo> list = new ArrayList<>();
		list.add(new UserInfo(3, "tome", 0, 27, sdf.parse("1991-05-18")));
		list.add(new UserInfo(2, "lily", 1, 23, sdf.parse("1996-12-25")));
		list.add(new UserInfo(4, "rose", 1, 20, sdf.parse("1989-10-08")));
		list.add(new UserInfo(0, "jack", 0, 23, sdf.parse("1993-03-20")));
		list.add(new UserInfo(1, "lucy", 1, 28, sdf.parse("1985-07-15")));
		return list;
	}

}
