package com.ztw.javaBase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.junit.Test;


public class LocalDateTest {
	
	@Test
	public void test001(){
		LocalDate today = LocalDate.now();
		LocalDate anyDay = LocalDate.of(2016, 6, 29);
		
		
		Period period = Period.between(today, anyDay);
		System.out.println(period.getDays());
		System.out.println(period.getMonths());
	}

	@Test
	public void test000(){
		LocalDate localDate01 = LocalDate.now();
		System.out.println(localDate01.isLeapYear());
		System.out.println(localDate01.plusDays(5));
		System.out.println(localDate01);
		System.out.println(LocalDate.of(2017, 04, 25).getClass());
		
		DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime time=LocalDateTime.parse("2016-05-25 15:53:55",df);  
        System.out.println(time);
	}
	
}
