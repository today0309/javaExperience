package com.ztw.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class Streams {

	@Test
	public void test001() {

		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		

		/**
		 * 1、Filter 
		 * Filter接受一个predicate来过滤流中的所有元素。这个操作是连续的，
		 * 它可以让我们在结果上继续调用另外一个流操作forEach。 ForEach接受一个consumer，它被用来对过滤流中的每个元素执行操作。
		 * ForEach是一个中断操作，因此我们不能在ForEach后调用其他流操作。
		 */
		List<String> list1 = stringCollection.stream().filter((s) -> s.startsWith("a")).collect(Collectors.toList());
		list1.forEach(e -> System.out.println(e));

		
		/**
		 * 2、Sorted 
		 * Sorted是一个连续操作，它返回流的已排序版本。如果你没有显示的指定Comparator，那么流中元素的排序规则为默认的。
		 * 需要注意的是sorted只创建了流的排序结果，它并没有改变集合中元素的排序位置。stringCollection中元素排序是没有改变的。
		 */
		List<String> list2 = stringCollection.stream().sorted().filter((s) -> s.startsWith("a"))
				.collect(Collectors.toList());
		list2.forEach(e -> System.out.println(e));
		
		
		/**
		 * 3、Map
		 * 连续性操作map通过指定的Function将流中的每个元素转变为另外的对象。下面的示例将每个字符串转换为大写的字符串。
		 * 此外，你也可以使用map将每个元素的类型改变为其它类型。转换后流的泛型类型依赖于你传入的Function的泛型类型。
		 * 
		 */
		List<String> list3 = stringCollection.stream().map(String::toUpperCase).sorted((a, b) -> a.compareTo(b))
				.collect(Collectors.toList());
		list3.forEach(e -> System.out.println(e));
		
		
		/**
		 * 4、Match
		 * 各种匹配操作可以用来检测是否某种predicate和流中元素相匹配。所有的这些操作是中断的并返回一个boolean结果。
		 */
		//集合内是否有元素是以 a 开头的
		boolean anyStartsWithA = stringCollection.stream().anyMatch(e -> e.startsWith("a"));
		System.out.println(anyStartsWithA);
		
		//集合内所有的元素是否都是以 a 开头
		boolean allStartWithA = stringCollection.stream().allMatch(e -> e.startsWith("a"));
		System.out.println(allStartWithA);
		
		//集合内是否存在不以 z 开头的元素
		boolean noneStartsWithZ = stringCollection.stream().noneMatch((s) -> s.startsWith("z"));
		System.out.println(noneStartsWithZ);

	}

}
