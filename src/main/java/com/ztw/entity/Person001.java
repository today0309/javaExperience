package com.ztw.entity;

public class Person001 implements Comparable<Person001> {

	public String name;

	public Integer age;

	public Person001() {

	}

	public Person001(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
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

	@Override
	public int compareTo(Person001 arg0) {
		return this.age - arg0.age;
	}

}
