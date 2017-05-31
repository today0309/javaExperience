package com.ztw.collection;

import java.util.Set;
import java.util.TreeSet;

import com.ztw.entity.Person001;

/**
 * 
 * TreeSet存储对象的时候, 可以排序, 但是需要指定排序的算法
 * Integer能排序(有默认顺序), String能排序(有默认顺序), 自定义的类存储的时候出现异常(没有顺序)
 * 如果想把自定义类的对象存入TreeSet进行排序, 那么必须实现Comparable接口
 * 在类上implement Comparable 重写compareTo()方法
 * 在方法内定义比较算法, 根据大小关系, 返回正数负数或零
 * 在使用TreeSet存储对象的时候, add()方法内部就会自动调用compareTo()方法进行比较, 根据比较结果使用二叉树形式进行存储
 * 
 * @author Administrator
 *
 */
public class TreeSetTest {

	public static void main(String[] args) {
		Set<Person001> allSet = new TreeSet<Person001>();
		try {
			allSet.add(new Person001("张三", 30));
			allSet.add(new Person001("李四", 31));
			allSet.add(new Person001("王五", 32));
			allSet.add(new Person001("王五", 32));
			allSet.add(new Person001("王五", 33));
			allSet.add(new Person001("赵六", 33));
			allSet.add(new Person001("孙七", 33));
			allSet.forEach(e -> System.out.println(e));
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}


