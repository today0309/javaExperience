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
	
}
