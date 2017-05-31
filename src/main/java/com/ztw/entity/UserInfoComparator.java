package com.ztw.entity;

import java.util.Comparator;

public class UserInfoComparator implements Comparator<UserInfo> {

	@Override
	public int compare(UserInfo o1, UserInfo o2) {
		int i = o1.getAge() - o2.getAge();// 先根据年龄排序
		int flag = i == 0 ? o1.getSex() - o2.getSex() : i;// 年龄相同按照性别排序
		return flag == 0 ? o1.hashCode() - o2.hashCode() : flag;// 如果年龄相同，性别相同，就根据哈希值排序
	}

}
