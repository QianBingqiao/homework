package com.qbq.threadoperation;
/**
 * 
 * @author QianBingqiao
 * @date 2017-05-31 14:16:21;
 * @Desterciption 创建一个继承Thread的类MyThread01
 *                在其run方法中输出”Thread01:1“后sleep1000毫秒
 */
public class MyThread01 extends Thread {
	int times;

	/**
	 * 
	 * @param times
	 *            线程打印次数
	 */
	public MyThread01(int times) {
		this.times = times;
	}

	/**
	 * 重写run方法，实现在其run方法中输出”Thread02:1“后sleep1000毫秒
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while (i < times) {
			i++;
			System.out.println("Thread01:" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (i == times) {
				break;
			}
		}
		
	}

}
