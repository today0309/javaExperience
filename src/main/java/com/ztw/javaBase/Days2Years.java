package com.ztw.javaBase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class Days2Years {

	private LocalDate startDay = LocalDate.of(2017, 3, 1);
	
	private LocalDate endDay = LocalDate.of(2017, 6, 8);
	

	
	@Test
	public void test000(){
		//System.out.println(endDay.toEpochDay() - startDay.toEpochDay());
		//execute();
		
		//BigDecimal xi = new BigDecimal(8.0);
		//BigDecimal yearBig = new BigDecimal(2.0);
		//BigDecimal i = BigDecimal.valueOf(StrictMath.pow(xi.doubleValue(), yearBig.doubleValue()));
		//System.out.println(i);
		System.out.println(StrictMath.pow(64, 1.0/(2)));
		System.out.println(StrictMath.pow(64, 2));
		System.out.println(365%365);
	}
	
	@Test
	public void test001(){
		double i = StrictMath.pow((new BigDecimal(0.951051)).doubleValue(), (new BigDecimal(1.13424658)).doubleValue());
		System.out.println(i);
		//long dayNum = 364;
		//long yearNum = 365;
		///System.out.println(BigDecimal.valueOf(dayNum).divide(BigDecimal.valueOf(yearNum), 4, BigDecimal.ROUND_HALF_UP));
	}
	
	@Test
	public void test002(){
		int i = 365;
		if(startDay.isLeapYear() && LocalDate.of(startDay.getYear(), 2, 29).isAfter(startDay)){
			i = 366;
		}
		if(endDay.isLeapYear() && LocalDate.of(endDay.getYear(), 2, 29).isAfter(endDay)){
			i = 366;
		}
		System.out.println(i);
	}
	
	@Test
	public void execute(){
		//long dayNum = endDay.toEpochDay() - startDay.toEpochDay();//相差天数
		//int startYear = startDay.getYear();
		//int endYear = endDay.getYear();
		int yearNum = 0;
		while(!startDay.plusYears(1).isAfter(endDay)){
			startDay = startDay.plusYears(1);
			yearNum++;
		}
		long dayNum = endDay.toEpochDay() - startDay.toEpochDay();
		System.out.println("相时间为：" + yearNum + "年" + dayNum + "天");
		
	}
}
