package com.ztw.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 定义代理角色
 * @author Administrator
 *
 */
public class DynamicSubject implements InvocationHandler{
	
	private Object obj;
	
	/**
	 * 绑定委托对象，并返回代理类
	 * @param obj
	 * @return
	 */
	public Object bind(Object obj){
		this.obj = obj;
		//绑定该类实现的所有接口，取得代理类
		/**
		 * Proxy这个类的作用就是用来动态创建一个代理对象的类，它提供了许多的方法，但是我们用的最多的就是 newProxyInstance 这个方法：
		 * public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, 
		 * InvocationHandler h) throws IllegalArgumentException
		 * 这个方法的作用就是得到一个动态的代理对象，其接收三个参数，我们来看看这三个参数所代表的含义：
		 * loader:　　一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
		 * interfaces:　　一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，
		 	那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
		 * h:　　一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
		 * 
		 * 
		 */
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		//此处可以进行所谓的AOP编程
		//在转调具体目标对象之前，可以执行一些功能处理
		System.out.println("***************开始***************");
		System.out.println("Method:" + method + ",Object[]" + args);
		result = method.invoke(obj, args);
		//在转调具体目标对象之后，可以执行一些功能处理
		System.out.println("***************结束***************");
		return result;
	}

}
