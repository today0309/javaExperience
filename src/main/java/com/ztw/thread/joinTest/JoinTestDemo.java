package com.ztw.thread.joinTest;


/**
 * 重要资料：http://blog.csdn.net/paincupid/article/details/47393563
 * 
 * @author Administrator
 *
 */
public class JoinTestDemo {
	
	/**
	JoinTestDemo: main start.  
    CustomThread1: [CustomThread1] Thread start.  
    [CustomThread1] Thread loop at 0  
    [CustomThread1] Thread loop at 1  
    JoinTestDemo: main end! // Thread.sleep(2000);结束，虽然在线程CustomThread执行了t1.join();，但这并不会影响到其他线程(这里main方法所在的线程)。  
    CustomThread: [CustomThread] Thread start.  //线程CustomThread起动，但没有马上结束，因为调用t1.join();，所以要等到t1结束了，此线程才能向下执行。  
    [CustomThread] Thread Custom at 0  
    [CustomThread] Thread Custom at 1  
    [CustomThread] Thread Custom at 2  
    [CustomThread] Thread Custom at 3  
    [CustomThread] Thread Custom at 4  
    [CustomThread1] Thread loop at 2      
    [CustomThread1] Thread loop at 3  
    [CustomThread1] Thread loop at 4  
    CustomThread1: [CustomThread1] Thread end.  
    [CustomThread] Thread Custom at 6  
    [CustomThread] Thread Custom at 7  
    [CustomThread] Thread Custom at 8  
    [CustomThread] Thread Custom at 9  
    CustomThread: [CustomThread] Thread end.  
	 */

	public static void main(String[] args) throws InterruptedException {
		String threadName = Thread.currentThread().getName();
		System.out.println("JoinTestDemo: " + threadName + " start.");
		CustomThread1 t1 = new CustomThread1();
		CustomThread ct = new CustomThread(t1);
		try {
			t1.start();
			Thread.sleep(2000);
			ct.start();
			ct.join();
		} catch (Exception e) {
			System.out.println("Exception from main");
		}
		System.out.println("JoinTestDemo: " + threadName + " end!");
	}

}
