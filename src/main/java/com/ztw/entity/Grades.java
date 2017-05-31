package com.ztw.entity;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

/**
 * 学生成绩
 * 
 * @author Administrator
 *
 */
public class Grades implements Comparable<Grades> {

	private String studentName;

	private int yuwen;

	private int shuxue;

	private int yingyu;

	private int wuli;

	private int huaxue;

	private int shengwu;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getYuwen() {
		return yuwen;
	}

	public void setYuwen(int yuwen) {
		this.yuwen = yuwen;
	}

	public int getShuxue() {
		return shuxue;
	}

	public void setShuxue(int shuxue) {
		this.shuxue = shuxue;
	}

	public int getYingyu() {
		return yingyu;
	}

	public void setYingyu(int yingyu) {
		this.yingyu = yingyu;
	}

	public int getWuli() {
		return wuli;
	}

	public void setWuli(int wuli) {
		this.wuli = wuli;
	}

	public int getHuaxue() {
		return huaxue;
	}

	public void setHuaxue(int huaxue) {
		this.huaxue = huaxue;
	}

	public int getShengwu() {
		return shengwu;
	}

	public void setShengwu(int shengwu) {
		this.shengwu = shengwu;
	}

	public Grades() {

	}

	public Grades(String studentName, int yuwen, int shuxue, int yingyu, int wuli, int huaxue, int shengwu) {
		super();
		this.studentName = studentName;
		this.yuwen = yuwen;
		this.shuxue = shuxue;
		this.yingyu = yingyu;
		this.wuli = wuli;
		this.huaxue = huaxue;
		this.shengwu = shengwu;
	}

	@Override
	public int compareTo(Grades arg0) {
		return ComparisonChain.start()
				.compare(this.yuwen, arg0.yuwen).compare(this.shuxue, arg0.shuxue)
				.compare(this.yingyu, arg0.yingyu).compare(this.wuli, arg0.wuli)
				.compare(this.huaxue, arg0.huaxue)
				.compare(this.shengwu, arg0.shengwu, Ordering.natural().nullsLast()).result();
	}

	@Override
	public String toString() {
		return "Grades [studentName=" + studentName + ", yuwen=" + yuwen + ", shuxue=" + shuxue + ", yingyu=" + yingyu
				+ ", wuli=" + wuli + ", huaxue=" + huaxue + ", shengwu=" + shengwu + "]";
	}
	
	
	

}
