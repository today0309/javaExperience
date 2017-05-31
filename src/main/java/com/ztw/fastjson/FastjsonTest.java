package com.ztw.fastjson;


import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ztw.entity.Person;

public class FastjsonTest {
	
	@Test
	public void test000(){
		Person person = new Person("ztw", 26);
		String str = JSON.toJSONString(person);//对象转json字符串
		System.out.println(str);
	}
	
	@Test
	public void test001(){
		String str = "{\"age\":26321,\"name\":\"ztw123\"}";
		Person person = JSON.parseObject(str, Person.class);//json字符串转对象
		System.out.println(person);
		
		JSONObject jobj = JSON.parseObject(str);
		System.out.println(jobj);
	}
	
	@Test
	public void test002(){
		List<Person> list = Lists.newArrayList();
		list.add(new Person("a001", 1));
		list.add(new Person("a002", 2));
		list.add(new Person("a003", 3));
		list.add(new Person("a004", 4));
		list.add(new Person("a005", 5));
		String str = JSON.toJSONString(list);//对象转json字符串
		System.out.println(str);
		
		List<Person> list01 = JSONArray.parseArray(str, Person.class);
		System.out.println(list01);
	}

}
