package com.ztw.javaBase;

import java.nio.charset.Charset;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

/**
 * 生成随机数的测试，主要包括常用的string的随机数的生成
 * 
 * @author Administrator
 *
 */
public class JavaRandomStringTest {

	@Test
	public void testRandom_generatingStringUnbounded() throws Exception {

		byte[] bytes = new byte[7];
		new Random().nextBytes(bytes);
		String s = new String(bytes, Charset.forName("UTF-8"));
		System.out.println(s);
	}

	@Test
	public void testRandom_generatingStringBounded_withRange() throws Exception {

		int leftLimit = 97;
		int rightLimit = 122;
		int targetStringLength = 10;
		StringBuilder builder = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLeft = leftLimit + ((int) (new Random().nextFloat() * (rightLimit - leftLimit + 1)));
			builder.append(((char) randomLeft));
		}
		System.out.println(builder.toString());
	}

	@Test
	public void testRandom_generatingStringBounded_withApacheLang() throws Exception {

		String generatedString = RandomStringUtils.random(10, true, false);
		System.out.println(generatedString);
	}

	@Test
	public void testRandom_generatingAlphabeticStringBounded_withApacheLang() throws Exception {

		// 生成只包含字母的
		System.out.println(RandomStringUtils.randomAlphabetic(10));
	}

	@Test
	public void testRandom_generatingAlphanumericStringBounded_withApacheLang() throws Exception {

		// 生成包含字母与数字的
		System.out.println(RandomStringUtils.randomAlphanumeric(10));
	}
}
