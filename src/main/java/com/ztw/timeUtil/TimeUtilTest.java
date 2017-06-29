package com.ztw.timeUtil;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class TimeUtilTest {
	
	private static String LONG_DATE_PATTERN_LINE = "yyyy-MM-dd HH:mm:ss";
	
	@Test
	public void test006(){
		String str = "20160205";
		LocalDate localDate = LocalDate.parse(str, DateTimeFormatter.BASIC_ISO_DATE);
		String newStr = DateTimeFormatter.ISO_LOCAL_DATE.format(localDate);
		System.out.println(newStr);
		String oldStr = "20170909009";
		oldStr = oldStr.length() > 8 ? oldStr.substring(0, 8) : oldStr;
		System.out.println(oldStr);
	}
	
	
	
	/**
	 * String转日期
	 */
	@Test
	public void test011(){
		System.out.println(LocalDateTime.parse("2017-06-02 12:32:12", DateTimeFormatter.ofPattern(LONG_DATE_PATTERN_LINE)));
		System.out.println(LocalDateTime.parse("2017-06-02T12:32:12", DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		System.out.println(LocalDate.parse("2017-06-02", DateTimeFormatter.ISO_DATE));
		System.out.println(LocalDate.parse("20170602", DateTimeFormatter.BASIC_ISO_DATE));
	}
	
	/**
	 * 日期格式转String
	 */
	@Test
	public void test010(){
		LocalDate localDate = LocalDate.now();// 2017-06-02
		LocalDateTime localDateTime = LocalDateTime.now();// 2017-06-02T14:10:44.025
		
		System.out.println(localDate);
		System.out.println(localDateTime);

		
DateTimeFormatter.BASIC_ISO_DATE.format(localDate);// 20170602	
DateTimeFormatter.BASIC_ISO_DATE.format(localDateTime);// 20170602
		System.out.println(DateTimeFormatter.BASIC_ISO_DATE.format(localDate));// 20170602
		System.out.println(DateTimeFormatter.BASIC_ISO_DATE.format(localDateTime));// 20170602
		
DateTimeFormatter.ISO_LOCAL_DATE.format(localDate);// 2017-06-02
DateTimeFormatter.ISO_LOCAL_DATE.format(localDateTime);// 2017-06-02
		
DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDate);// 抛出异常
DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(localDateTime);// 2017-06-02T14:10:44.025
		
DateTimeFormatter.ofPattern(LONG_DATE_PATTERN_LINE).format(localDate);// 抛出异常
DateTimeFormatter.ofPattern(LONG_DATE_PATTERN_LINE).format(localDateTime);// 2017-06-02 14:10:44
	}
	
	@Test
	public void test003(){
		List<Integer> list1 = Lists.newArrayList(1, 3, 5, 7, 9);
		List<Integer> list2 = Lists.newArrayList(1, 3, 5, 7);
		list1.removeAll(list2);
		System.out.println(list1);
	}
	
	@Test
	public void test002(){
		List<String> list = Lists.newArrayList();
		LocalDate endDate = LocalDate.now().minusDays(1);//截止日期为当前日期的前一天
		LocalDate startDate = LocalDate.now().minusYears(1);//起始日期为一年前
		boolean bContinue = true;
		LocalDate date = startDate;
		while(bContinue){
			list.add(DateTimeFormatter.ISO_LOCAL_DATE.format(date));
			System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(date));
			date = date.plusDays(1);
			if(date.isAfter(endDate)){
				break;
			}
		}
		System.out.println(list);
	}
	
	@Test
	public void test000(){
		System.out.println(LocalDate.now());
		System.out.println(LocalDateTime.now());
		System.out.println("*****");
	}

	@Test
	public void test001(){
		String now = TimeUtil.getCurrentDatetime();
		System.out.println(now);
	}
}
