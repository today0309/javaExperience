package com.ztw.proxy.easy.dao.impl;

/***
 * 此类没有实现任何接口，只能使用Cglib代理来调用方法
 * 必须有无参的构造方法
 * @author qindongliang
 *
 */
public class CarManager {
	
	private String name;
	
	
	public CarManager() {
		// TODO Auto-generated constructor stub
	}
	
	public CarManager(String name) {
		this.name = name;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void run()throws Exception{
		System.out.println(this.getName()+"汽车启动了!");
		Thread.sleep(3000);
	}

	
	
	public void stop(){
		System.out.println(this.getName()+"汽车停止了!");
	}
	
	
	

}
