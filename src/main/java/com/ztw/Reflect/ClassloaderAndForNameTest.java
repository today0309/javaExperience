package com.ztw.Reflect;

/**
 * Class.forName和classloader的区别
 * <p>
 * Created by lxk on 2017/2/21
 */
public class ClassloaderAndForNameTest {
	
	
	public static void main(String[] args) {
		System.out.println("Boolean: " + Boolean.toString(false));  
		String wholeNameLine = "com.ztw.Reflect.Line";
		String wholeNamePoint = "com.ztw.Reflect.Point";
		System.out.println("下面是测试Classloader的效果");
		testClassloader(wholeNameLine, wholeNamePoint);
		System.out.println("----------------------------------");
		System.out.println("下面是测试Class.forName的效果");
		testForName(wholeNameLine, wholeNamePoint);

	}

	/**
	 * classloader
	 */
	private static void testClassloader(String wholeNameLine, String wholeNamePoint) {
		Class<?> line;
		Class<?> point;
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		try {
			line = loader.loadClass(wholeNameLine);
			point = loader.loadClass(wholeNamePoint);
			// demo =
			// ClassloaderAndForNameTest.class.getClassLoader().loadClass(wholeNamePoint);//这个也是可以的
			System.out.println("line   " + line.getName());
			System.out.println("point   " + point.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Class.forName
	 */
	private static void testForName(String wholeNameLine, String wholeNamePoint) {

		try {
			Class line = Class.forName(wholeNameLine);
			Class point = Class.forName(wholeNamePoint);
			System.out.println("line   " + line.getName());
			System.out.println("point   " + point.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}