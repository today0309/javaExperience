package com.ztw.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class SupplierTest {

	@Test
	public void test001(){
		Random seed = new Random();
		Supplier<Integer> random = seed::nextInt;
		Stream.generate(random).limit(10).forEach(System.out::println);
		//Another way
		IntStream.generate(() -> (int) (System.nanoTime() % 100)).limit(10).forEach(System.out::println);
	}
	
}
