package com.ztw.timeUtil;

import java.text.ParseException;

public class DateUtilTest {

	public static class TestSimpleDateFormatThreadSafe extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					this.join(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				try {
					System.out.println(this.getName() + ":" + DateUtil.parse("2013-05-24 06:02:20"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			new TestSimpleDateFormatThreadSafe().start();
		}

	}

}
