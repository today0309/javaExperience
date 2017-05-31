package com.ztw.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.ztw.entity.Person;

public class MapTest {

	@Test
	public void test001() {
		Map<Integer, Person> map = new HashMap<Integer, Person>();
		map.put(362323823, new Person("lily", 25));
		map.put(362323813, new Person("lucy", 23));
		map.put(362323833, new Person("tome", 18));
		map.put(362323853, new Person("kety", 23));
		map.put(362323803, new Person("dava", 20));

		List<Entry<Integer, Person>> list = Lists.newArrayList(map.entrySet());
		list.forEach(e -> System.out.println(e));

		Collections.sort(list, new Comparator<Entry<Integer, Person>>() {

			public int compare(Entry<Integer, Person> o1, Entry<Integer, Person> o2) {
				/**
				 * o1.getValue().getAge() - o2.getValue().getAge(); 表示按照年龄升序
				 * o2.getValue().getAge() - o1.getValue().getAge(); 表示按照年龄降序
				 */
				int result = o1.getValue().getAge() - o2.getValue().getAge();
				result = result == 0 ? o1.hashCode() - o2.hashCode() : result;
				return result;
			}

		});
		System.out.println(list);
		LinkedHashMap<Integer, Person> linkedHashMap = new LinkedHashMap<Integer, Person>();
		for (Map.Entry<Integer, Person> entry : list) {
			linkedHashMap.put(entry.getKey(), entry.getValue());
		}
		System.out.println(linkedHashMap);
	}

	// 常用的Map遍历方式
	public static void main01(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("JAVA", "98");
		map.put("PHP", "95");
		map.put("C++", "100");
		map.put("HTML", "85");
		map.put("SQL", "75");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("key为：" + entry.getKey() + ",对应的value为：" + entry.getValue());
		}
	}

}