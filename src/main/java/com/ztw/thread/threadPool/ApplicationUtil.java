package com.ztw.thread.threadPool;

import org.springframework.beans.BeansException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时候中取出ApplicaitonContext.
 * 
 * 辅助类，从spring容器里获取对象
 * 
 * @author zhongpengxiang
 *
 */
public class ApplicationUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	/**
	 * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
	 */
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplicationUtil.applicationContext = applicationContext;
	}

	/**
	 * 根据bean名称从spring容器里获取实例
	 * 
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		checkApplicationContext();
		return applicationContext.getBean(name);
	}

	private static void checkApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
		}
	}

}