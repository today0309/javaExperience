package com.ztw.proxy.easy.main;

import java.lang.reflect.InvocationHandler;

import java.lang.reflect.Proxy;

import com.ztw.proxy.easy.dao.PersonDao;
import com.ztw.proxy.easy.dao.impl.CarManager;
import com.ztw.proxy.easy.dao.impl.PersonDaoImpl;
import com.ztw.proxy.easy.model.Person;
import com.ztw.proxy.easy.proxy.CGLIB_Proxy;
import com.ztw.proxy.easy.proxy.JDK_Proxy;



public class MethodTest {
	
	public static void main(String[] args) throws Exception {
		//cglibProxyTest();
		jdkProxyTest();
	}

	
	/****
	 * cglib代理测试
	 */
	public static void cglibProxyTest()throws Exception{
		
		
		CarManager car=new CarManager("大众");
		String userName = "lucy";
//		
//		car.run();
//		car.stop();
		//得到代理类对象
		CarManager carManager=CGLIB_Proxy.proxyTarget(car, userName);
		carManager.run();
		
	}
	
	
	/***
	 * jdk动态代理
	 */
	public static void jdkProxyTest() {
		PersonDao user=new PersonDaoImpl();
		
		Class<?> cls=user.getClass();
		
		InvocationHandler handler=new JDK_Proxy(user);
		
		//转换得来的代理对象
		PersonDao proxy=(PersonDao)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), handler);
		
		proxy.addUser(new Person("hadoop"));
		proxy.deleteUser("lucene");
		proxy.updateUser("solr and elasticsearch");
	}
	
}
