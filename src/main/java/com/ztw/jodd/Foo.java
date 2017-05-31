package com.ztw.jodd;

public class Foo {

	private String readwrite; // with getter and setter

	private String readonly; // with getter

	public String getReadwrite() {
		return readwrite;
	}

	public void setReadwrite(String readwrite) {
		this.readwrite = readwrite;
	}

	public String getReadonly() {
		return readonly;
	}

}
