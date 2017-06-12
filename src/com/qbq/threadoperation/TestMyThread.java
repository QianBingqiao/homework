package com.qbq.threadoperation;

import java.util.Collections;

/**
 * 
 * @author QianBingqiao
 * @date 2017-05-31 14:40:33;
 * @Desterciption 对比线程，观察特点
 */
public class TestMyThread {
	
	public static void main(String[] args) {
		//创建MyThread01,MyThread02的两个对象
		MyThread01 thread1 = new MyThread01(10);
		MyThread02 thread2 = new MyThread02(10);
		//继承Thread类的线程的启动方法
		thread1.setPriority(1);
		thread1.start();
		//实现 Runnable接口的线程的启动方法
		Thread t1 =new Thread(thread2);
		t1.setPriority(10);
		t1.setDaemon(true);
		t1.start();
//		Collections.synchronizedList();
	}
	//3.输出结果的特点就是，两个线程每当沉睡1000毫秒之后都会重新获取cpu而且，
	//譬如第一次是thread1 先获取到cpu则当执行完之后有可能是thread2获取到cpu,
	//也有可能还是thread1,获取到cpu；
	
	//4.经过重新设置线程优先级之后，输出结果的特点就是，两个线程每当沉睡1000毫秒之后都会重新获取cpu而且，
	//譬如第一次是thread1 先获取到cpu则当执行完之后有可能是thread2获取到cpu,
	//也有可能还是thread1,获取到cpu，只不过thread2对象获取到线程的概率有所增加，
	//但并不完全优先执行thread2
	
	//5.把MyThread02设置成守护线程之后，当MyThread01的对象thread1线程执行结束之后，
	//不论MyThread02线程的对象thread2有没有执行完，线程都会结束进程

}
