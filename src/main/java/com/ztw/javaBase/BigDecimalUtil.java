package com.ztw.javaBase;

import java.math.BigDecimal;

/**
 * 8种舍入模式：http://www.bdqn.cn/news/201311/11834.shtml
 * 
 * @author Administrator
 *
 */
public class BigDecimalUtil {

	/**
	 * 四舍五入保留 i 位小数点
	 * 
	 * @param num
	 * @return
	 */
	public static BigDecimal rounding(BigDecimal num, int i) {
		if (num == null) {
			return new BigDecimal(0).setScale(i);
		}
		return num.setScale(i, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 四舍五入保留2位小数点
	 * 
	 * @param num
	 * @return
	 */
	public static BigDecimal rounding(BigDecimal num) {
		return rounding(num, 2);
	}

	/**
	 * BigDecimal 转为百分数，并保留 i 为小数点
	 * @param num
	 * @param i
	 * @return
	 */
	public static String bigDecimal2Percent(BigDecimal num, int i) {
		BigDecimal newNum;
		if (num == null) {
			newNum = new BigDecimal(0).setScale(i);
		} else {
			newNum = num.multiply(new BigDecimal(100)).setScale(i, BigDecimal.ROUND_HALF_UP);
		}
		return newNum.toString().concat("%");
	}

	/**
	 * BigDecimal 转为百分数，并保留 2 为小数点
	 * @param num
	 * @param i
	 * @return
	 */
	public static String bigDecimal2Percent(BigDecimal num) {
		return bigDecimal2Percent(num, 2);
	}

	public static void main(String[] args) {
		// System.out.println(rounding(new BigDecimal("0.9766123123"), 2));
		// System.out.println(rounding(null, 3));
		System.out.println(bigDecimal2Percent(new BigDecimal("593213.3232323212312"), 8));
		System.out.println(bigDecimal2Percent(null, 7));
	}

}
