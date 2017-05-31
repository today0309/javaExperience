package com.ztw.thread.threadPool.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ztw.thread.threadPool.mapper.FundMapper;

public class FundMapperTest extends BaseTest {

	@Autowired
	private FundMapper fundMapper;
	
	@Test
	public void test000(){
		try {
			List<Integer> list = fundMapper.getAllMoneyFund();
			System.out.println(list);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
}
