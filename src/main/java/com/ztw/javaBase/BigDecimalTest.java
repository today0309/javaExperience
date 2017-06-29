package com.ztw.javaBase;

import java.math.BigDecimal;

import org.junit.Test;


/**
 *     BigDecimal常用方法描述

    add(BigDecimal)            BigDecimal对象中的值相加，然后返回这个对象。
    subtract(BigDecimal)    BigDecimal对象中的值相减，然后返回这个对象。
    multiply(BigDecimal)    BigDecimal对象中的值相乘，然后返回这个对象。
    divide(BigDecimal)        BigDecimal对象中的值相除，然后返回这个对象。
    toString()                         将BigDecimal对象的数值转换成字符串。
    doubleValue()                 将BigDecimal对象中的值以双精度数返回。
    floatValue()                     将BigDecimal对象中的值以单精度数返回。
    longValue()                     将BigDecimal对象中的值以长整数返回。
    intValue()                       将BigDecimal对象中的值以整数返回。
 * @author Administrator
 *
 */
public class BigDecimalTest {
	
	private static final BigDecimal num1 = new BigDecimal("78.98877");
	
	private static final BigDecimal num2 = new BigDecimal("981.9888776");
	
	private static final BigDecimal num3 = new BigDecimal("0.0987654");
	
	private static final BigDecimal num4 = new BigDecimal("1.22");
	
	@Test
	public void test001(){
		BigDecimal num = num1.divide(new BigDecimal(1) ,2 ,BigDecimal.ROUND_HALF_UP);
		System.out.println(num);
	}

	@Test
	public void test000(){
		System.out.println(num4);
		System.out.println(num1.add(num2));
	}
	
	@Test
	public void test(){
		System.out.println(0.06+0.01);
	}
	
	@Test
	public void bigDecimalTest(){
		double d1 = 12.98732908;
		double d2 = 0.987123123;
		
		System.out.println(BigDecimal.valueOf(d1));// 12.98732908
		System.out.println(new BigDecimal(12.0));// 12
		System.out.println(new BigDecimal(12.98732908));
		// 12.9873290800000003031300366274081170558929443359375
		System.out.println(new BigDecimal("12.98732908"));// 12.98732908
		
		BigDecimal b1 = BigDecimal.valueOf(d1);
		BigDecimal b2 = BigDecimal.valueOf(d2);
		
		System.out.println(b1.add(b2));//加法
		System.out.println(b1.subtract(b2));//减法
		System.out.println(b1.multiply(b2));//乘法
		System.out.println(b1.divide(b2, 4, BigDecimal.ROUND_HALF_UP));//除法，四舍五入保留4位小数
	}

	
}
