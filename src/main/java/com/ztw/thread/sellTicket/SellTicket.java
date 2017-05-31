package com.ztw.thread.sellTicket;

import java.util.concurrent.CountDownLatch;

public class SellTicket implements Runnable {

	public static int tickets = 50; // count of tickets

	public static int unit_price = 30; // unit_price of per ticket

	public static int sum_price = 0; // total turnover

	private int pre_counts;

	private String thread_name;
	
	private CountDownLatch countDownLatch;

	// 设置对象锁，否则同步时将抛出异常
	private static String s_flag = "flag_of_objectlock";

	public SellTicket(String name, CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
		thread_name = name;
		pre_counts = tickets;
	}

	// 核实买方帐户
	private void accountVerify() {
		System.out.printf("Thread %s: 账号是有效的!\n", thread_name);
	}

	// 前期准备
	private void pre_Jobs() {
		System.out.printf("Thread %s: 准备完毕!\n", thread_name);
	}

	private void sellTicket() throws Exception {
		accountVerify();
		pre_Jobs();
		/**
		 * synchronized (i_flag) error integer variable is not an object try to
		 * lock the object i_flag
		 */
		synchronized (s_flag) {
			if (tickets > 0) {
				System.out.printf("Thread %s: 售出 no.%d 号票!\n", thread_name, pre_counts - tickets + 1);
				tickets--;
				sum_price += unit_price;
				Thread.sleep(3000);
			} else {
				System.out.printf("Thread %s: 所有的票都卖完了!\n", thread_name, pre_counts - tickets + 1);
			}
		}
	}

	@Override
	public void run() {
		try {
			while (tickets > 0) {
				sellTicket();
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			countDownLatch.countDown();
		}
		System.out.printf("Turnover is %d\n", SellTicket.sum_price);
	}

}
