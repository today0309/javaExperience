package com.ztw.collection;

import java.util.Set;
import java.util.TreeSet;



public class TreeSetTest001 {

	public static void main(String[] args) {
		Set<Person002> allSet = new TreeSet<Person002>();
		allSet.add(new Person002("张三", 30));
		allSet.add(new Person002("李四", 31));
		System.out.println(allSet);
	}
}
class Person002{
	public String name;
	public Integer age;
	public Person002(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}