package com.ztw.streams;

public class Item {

	private String itemName;

	private long price;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", price=" + price + "]";
	}

	public Item(String itemName, long price) {
		this.itemName = itemName;
		this.price = price;
	}
}
