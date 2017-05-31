package com.ztw.springSingleton;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test001 {

	@Test
	public void test001(){
		String springConfig = "classpath:/com/ztw/springSingleton/spring.xml";  
        //创建一个SpringContainer  
        ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
		
		SingletonTest001 singletonTest001 = (SingletonTest001) context.getBean("singletonTest001");
		SingletonTest002 singletonTest002 = (SingletonTest002) context.getBean("singletonTest002");
		SingletonBean singletonBean = (SingletonBean) context.getBean("singletonBean");
		
		//输出上一次操作singltonBean的Bean名称，   
        //因为在这之前没有对singletonBean的lastOperatedBy属性进行初始化，所以这里应该会输出none   
        singletonBean.showLastOperateBean();  
          
        //设置runnerBeanOne中singletonBean对象的上一次操作者信息为runnerBeanOne   
        //singletonTest001.setBeanName();;  
        //通过singletonBean输出上一次操作者信息   
        //singletonBean.showLastOperateBean();  
        //输出runnerBeanTwo中应用的singletonBean对象的上一次操作者信息   
        //singletonTest002.showBeanName();;  
          
       //设置runnerBeanOne中singletonBean对象的上一次操作者信息为runnerBeanTwo   
        //singletonTest002.setBeanName();  
       //通过singletonBean输出上一次操作者信息   
        //singletonBean.showLastOperateBean();  
       //输出runnerBeanOne中应用的singletonBean对象的上一次操作者信息   
        //singletonTest001.showBeanName();
	}
}
