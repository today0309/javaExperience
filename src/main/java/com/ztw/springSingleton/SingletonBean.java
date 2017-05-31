package com.ztw.springSingleton;

/**
 * 
 * @author Administrator
 *
 */
public class SingletonBean {

	private String lastOperateBy;

	public String getLastOperateBy() {
		return lastOperateBy;
	}

	public void setLastOperateBy(String lastOperateBy) {
		this.lastOperateBy = lastOperateBy;
	}

	public void showLastOperateBean() {
		if (lastOperateBy != null) {
			System.out.println(lastOperateBy);
		} else {
			System.out.println("none");
		}
	}

}
