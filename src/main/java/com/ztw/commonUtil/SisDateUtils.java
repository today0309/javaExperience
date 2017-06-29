package com.ztw.commonUtil;

import java.util.Date;

public class SisDateUtils {

	public static String formateDate(Date textTime) {
		String showTime = "";
		// 当前时间：秒
		long nowSecond = System.currentTimeMillis() / 1000;
		// 资讯创建时间：秒
		long upSecond = textTime.getTime() / 1000;
		if (nowSecond <= upSecond) {
			showTime = "1分钟前";
		} else if (DateUtils.isToday(textTime)) {
			if ((nowSecond - upSecond) < 3600) {
				long minute = (nowSecond - upSecond) / 60;
				if (minute <= 0) {
					showTime = String.valueOf("1分钟前");
				} else {
					showTime = String.valueOf(minute + "分钟前");
				}
			} else {
				showTime = DateUtils.formatDate(textTime, DateUtils.FMT_DATE_HHMM);
			}
		} else if (isSameYear(textTime, new Date())) {
			showTime = DateUtils.formatDate(textTime, DateUtils.FMT_DATE_MMDD_HHMM);
		} else {
			showTime = DateUtils.formatDate(textTime, DateUtils.FMT_DATE_YYYYMMDDHHMM);
		}
		return showTime;
	}

	public static String formateSimpleDate(Date textTime) {
		String showTime = "";
		if (DateUtils.isToday(textTime)) {
			showTime = DateUtils.formatDate(textTime, DateUtils.FMT_DATE_HHMM);
		} else if (isSameYear(textTime, new Date())) {
			showTime = DateUtils.formatDate(textTime, DateUtils.FMT_DATE_MMDD_HHMM);
		} else {
			showTime = DateUtils.formatDate(textTime, DateUtils.FMT_DATE_YYYYMMDDHHMM);
		}
		return showTime;
	}

	public static boolean isSameYear(Date date1, Date date2) {
		// 不需要写。。。。。。
		return true;
	}

}
