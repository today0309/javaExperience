package com.ztw.guava;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;


/**
 * FluentIterable 是guava集合类中常用的一个类，主要用于过滤、转换集合中的数据；
 * FluentIterable 是一个抽象类，实现了Iterable接口，大多数方法都返回FluentIterable对象，这也是guava的思想之一。
 * @author Administrator
 *
 */
public class FluentIterableTest {

	public List<Person> getList() {
		List<Person> list = Lists.newArrayList();
		Random random = new Random();
		for (int i = 0; i < 7; i++) {
			list.add(new Person("name" + i, random.nextInt(10) + 15));
		}
		System.out.println("全部数据如下：");
		list.forEach(e -> System.out.println(e));
		return list;
	}

	@Test
	public void test002() {
		List<Person> list = getList();
		FluentIterable<Person> newList = FluentIterable.from(list).filter(new Predicate<Person>() {
			@Override
			public boolean apply(Person input) {
				return input.getAge() > 20;
			}
		});
		System.out.println(newList.getClass());
		System.out.println("过滤后的数据为：");
		newList.forEach(e -> System.out.println(e));
	}

	@Test
	public void test001() {
		List<Person> list = getList();
		/**
		 * 1、创建一个iterable的包装类型FluentItable 2、filter
		 * 将Predicate绑定到每个元素，在调用contains等方法时进行调用
		 */
		Iterable<Person> iterable = FluentIterable.from(list).filter(new Predicate<Person>() {
			@Override
			public boolean apply(Person input) {
				return input.getAge() > 20;
			}
		});
		List<Person> list1 = Lists.newArrayList();
		Iterator<Person> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			list1.add(iterator.next());
		}
		System.out.println("过滤后的数据如下：");
		System.out.println(list1);
	}

}

class Person {

	public String name;

	public Integer age;

	public Person(String name, Integer age) {
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

}