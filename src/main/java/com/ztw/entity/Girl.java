package com.ztw.entity;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;

public class Girl implements Comparable<Girl> {

	private String name;// 名称

	private double height;// 身高

	private String face;// 长相

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	// 传统方法
	public int compareTo_old(Girl girl) {
		int c1 = name.compareTo(girl.name);
		if (c1 != 0) {
			System.out.println("两个girl的name不相同");
			return c1;
		}
		int c2 = Double.compare(height, girl.height);
		if (c2 != 0) {
			System.out.println("两个girl的height不相同");
			return c2;
		}
		int c3 = face.compareTo(girl.face);
		if (c3 != 0)
			System.out.println("两个girl的face不相同");
		return c3;
	}

	/**
	 * 使用Guava提供的ComparisonChain我们这样比较
	 * 
	 * start()用于返回内部的一个 ComparisonChain实现；
	 * 重载了许多compare()方法，用于接收各种类型的参数，compare方法返回的仍然是 ComparisonChain对象；
	 * result()方法用于返回比较后的结果。
	 * @param girl
	 * @return
	 */
	public int compareTo_new(Girl girl) {
		return ComparisonChain.start().compare(name, girl.name).compare(height, girl.height).compare(face, girl.face)
				.result();
	}

	@Override
	public int compareTo(Girl o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
