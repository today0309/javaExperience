package com.ztw.thread.threadPool.mapper;

import java.math.BigDecimal;
import java.util.List;

public interface FundMapper {

	//获取所有的货币基金InnerCode
	List<Integer> getAllMoneyFund();
	
	//根据InnerCode获取LatestWeeklyYield的平均值
	BigDecimal getAvgLatestWeeklyYieldByInnerCode(Integer innerCode);
		
}
