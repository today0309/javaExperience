package com.ztw.proxy.easy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
/***
 * JDK动态代理例子
 * @author qindongliang
 *
 */
public class JDK_Proxy implements InvocationHandler {
	
	//代理实例
	private Object proxy;
	//通过构造参数赋值
	public JDK_Proxy(Object proxy) {
		this.proxy = proxy;
	}

	//格式化时间
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
	
	



	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object obj=null;
		//开始时间
		long start=System.currentTimeMillis();
		//以add开头的方法，加入事务控制
		if(method.getName().startsWith("add")){
			//开启事务
			startTransaction(method);
			obj=method.invoke(this.proxy, args);
			//关闭事务
			closeTransaction(method);
		}else{
			obj=method.invoke(this.proxy, args);
		}
		
		//调用结束时间
		long end=System.currentTimeMillis();
		System.out.println(sdf.format(new Date())+"  "+method.getName()+"调用方法执行时间为："+(end-start)/1000+"秒！");
		System.out.println();
		return obj;
	}
	
	//模拟开启事务
	public void startTransaction(Method method){
		System.out.println("请注意："+method.getName()+"开启了 commit 事务操作 ！");
	}
	
	//模拟关闭事务
	public void closeTransaction(Method method){
		System.out.println("请注意："+method.getName()+"关闭了 commit 事务操作 ！");
	}
	
	
	
	
	
	
	
	

}
