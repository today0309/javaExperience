package com.ztw.entity;

public class Products implements Comparable<Products> {

	private String title;

	private int price;

	public Products() {

	}

	public Products(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [title=" + title + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Products arg0) {
		return this.getPrice() - arg0.getPrice();
	}
}
