package com.ztw.proxy.easy.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/***
 * Cglib代理测试
 * @author qindongliang
 */
public class CGLIB_Proxy implements MethodInterceptor{

	//代理对象
	private Object target;
	
	private String userName;
	
	
	
	 @SuppressWarnings("unchecked")  
	 public static <T> T proxyTarget(T t, String userName) {  
	        Enhancer en = new Enhancer();  
	        en.setSuperclass(t.getClass());  
	        en.setCallback(new CGLIB_Proxy(t, userName));  
	        T tt = (T) en.create();  
	        return tt;  
	 }  
	
	 
	public CGLIB_Proxy(Object target, String userName) {
		this.target = target;
		this.userName = userName;
	}





	@Override
	public Object intercept(Object arg0, Method method, Object[] args,MethodProxy arg3) throws Throwable {
		
		System.out.println("调用 "+method.getName()+" 开始......  ");
		System.out.println(userName);
		//调用代理
		Object obj=method.invoke(this.target, args);
		System.out.println("调用 "+method.getName()+" 结束......  ");
		return obj;
	}
	
	
	
	
	
	

}
