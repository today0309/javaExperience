package com.ztw.sort;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Ordering;
import com.ztw.entity.UserInfo;
import com.ztw.entity.UserInfoComparator;

/**
 * java8 排序方式
 * 
 * @author Administrator
 *
 */
public class Sort {
	
	
	/**
	 * 使用com.google.common.collect.Ordering<T> 排序
	 * @throws Exception
	 */
	@Test
	public void test004() throws Exception {
		List<UserInfo> list = getUserInfoList();
		Ordering<UserInfo> order = new Ordering<UserInfo>(){
			@Override
			public int compare(UserInfo left, UserInfo right) {
				//return left.getAge() - right.getAge();
				return left.getUserName().compareTo(right.getUserName());
			}
		};
		list.forEach(e -> System.out.println(e));
		System.out.println("*************");
		List<UserInfo> list1 = new ArrayList<>(order.sortedCopy(list));
		list.forEach(e -> System.out.println(e));
		System.out.println("*************");
		list1.forEach(e -> System.out.println(e));
	}

	/**
	 * 类似于 test001() 方法
	 * 
	 * @throws Exception
	 */
	@Test
	public void test003() throws Exception {
		List<UserInfo> list = getUserInfoList();
		Collections.sort(list, new UserInfoComparator());
		list.forEach(e -> System.out.println(e));
	}

	/**
	 * java8之后的排序（根据年龄升序显示）
	 * 
	 * @throws Exception
	 */
	@Test
	public void test002() throws Exception {
		List<UserInfo> list = getUserInfoList();
		System.out.println("********************原始数据：********************");
		list.forEach(e -> System.out.println(e));
		System.out.println("********************原始数据：********************");
		Collections.sort(list, (UserInfo arg0, UserInfo arg1) -> {
			return arg0.getAge() - arg1.getAge();
		});
		System.out.println("********************排序后数据：********************");
		list.forEach(e -> System.out.println(e));
		System.out.println("********************排序后数据：********************");
	}

	/**
	 * java8之前的排序（根据年龄升序显示）
	 * 
	 * @throws Exception
	 */
	@Test
	public void test001() throws Exception {

		List<UserInfo> list = getUserInfoList();
		System.out.println("********************原始数据：********************");
		list.forEach(e -> System.out.println(e));
		System.out.println("********************原始数据：********************");
		Collections.sort(list, new Comparator<UserInfo>() {
			@Override
			public int compare(UserInfo arg0, UserInfo arg1) {
				int i = arg0.getAge() - arg1.getAge();
				return i;
			}
		});
		System.out.println("********************排序后数据：********************");
		list.forEach(e -> System.out.println(e));
		System.out.println("********************排序后数据：********************");

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
