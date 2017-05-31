package com.ztw.netty;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		try {
			System.out.println("*********************");
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/ztw/netty/spring.xml");
			AbstractNettyServer tcpServer = (AbstractNettyServer) context.getBean("tcpServer");
			tcpServer.startServer();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
