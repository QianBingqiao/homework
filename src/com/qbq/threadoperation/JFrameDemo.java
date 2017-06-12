package com.qbq.threadoperation;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 
* @ClassName: JFrameDemo 
* @Description: TODO(编写一个线程改变窗体的颜色V1,使用Runnable创建线程，
* 该线程实现窗口的颜色在黑色和白色之间不断的切换。) 
* @author QianBingqiao 
* @date 2017年5月31日 下午5:10:52 
*
 */
public class JFrameDemo implements Runnable{
	JPanel panel;
	JFrame frame;
	public JFrameDemo(){
		JPanel panel= new JPanel();
		JFrame frame = new JFrame();
		
		frame.setLocation(100, 100);
		frame.setSize(300, 300);
		frame.setVisible(true);
		panel.setSize(300,300);
		panel.setVisible(true);
		frame.add(panel);
		frame.setContentPane(panel);
		

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while(true){
			i++;
			if(i%2 ==0){
				System.out.println(i);
				panel.setBackground(Color.black);
				panel.updateUI();
				System.out.println(i);
			
			}else{
				panel.setBackground(Color.white);
				panel.updateUI();
			}
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
	public static void main(String[] args) {
		JFrameDemo f = new JFrameDemo();
		Thread thread = new Thread(f);
		thread.start();

		JPanel panel= new JPanel();
		JFrame frame = new JFrame();
		
		frame.setLocation(100, 100);
		frame.setSize(300, 300);
		frame.setVisible(true);
		panel.setSize(300,300);
		panel.setVisible(true);
		frame.add(panel);
		frame.setContentPane(panel);


		Thread thread1 = new Thread(){
	
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int i = 0;
				while(true){
					i++;
					if(i%2 ==0){
						System.out.println(i);
						panel.setBackground(Color.black);
						panel.updateUI();
						System.out.println(i);
					
					}else{
						panel.setBackground(Color.white);
						panel.updateUI();
					}
				
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
			}
		};
		thread1.start();
		
	}
	
}
