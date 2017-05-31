package com.ztw.springSingleton;

public class SingletonTest002 {


	private String beanName;
	
	private SingletonBean singletonBean;

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public SingletonBean getSingletonBean() {
		return singletonBean;
	}

	public void setSingletonBean(SingletonBean singletonBean) {
		this.singletonBean = singletonBean;
	}
	
	public void setBeanName(){
		singletonBean.setLastOperateBy(beanName);
	}
	
	public void showBeanName(){
		singletonBean.showLastOperateBean();
	}
	
	

}
