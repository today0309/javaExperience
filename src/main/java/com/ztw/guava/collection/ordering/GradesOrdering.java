package com.ztw.guava.collection.ordering;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.ztw.entity.Grades;

public class GradesOrdering {
	
	@Test
	public void test001(){
		List<Grades> list = getList();
		list.forEach(e -> System.out.println(e));
		Collections.sort(list);
		System.out.println("**********");
		list.forEach(e -> System.out.println(e));
	}

	public List<Grades> getList(){
		List<Grades> list = Lists.newArrayList();
		list.add(new Grades("student1", 80, 95, 90, 60, 75, 55));
		list.add(new Grades("student7", 80, 95, 90, 60, 75, 60));
		list.add(new Grades("student3", 80, 95, 90, 60, 35, 55));
		list.add(new Grades("student4", 80, 95, 90, 60, 75, 55));
		list.add(new Grades("student2", 58, 95, 90, 60, 75, 55));
		list.add(new Grades("student6", 80, 95, 90, 60, 70, 55));
		list.add(new Grades("student5", 80, 95, 90, 60, 75, 58));
		list.add(new Grades());
		return list;
	}
}
