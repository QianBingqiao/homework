package com.qbq.socketoperation;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 
* @ClassName: Client3 
* @Description: TODO(在Client2的基础上不变) 重构聊天室案例，使用线程来实现一个服务器端可以同时接收多个客户端的信息
* @author QianBingqiao 
* @date 2017年6月2日 下午4:15:54 
*
 */
public class Client3 {
	/**
	 * Socket
	 */
	Socket client;
	Scanner sc;
	
	public Client3(){
		try {
			client = new Socket("localhost",8088);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//实现客户端重复发送数据到服务器端的功能。即，用户可以在控制台不断输入内容，并将内容逐一发送给服务端。
	public void start(){
		try {
			 sc = new Scanner(System.in);
			OutputStream os = client.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(os, "utf-8");
			PrintWriter print = new PrintWriter(writer,true);
			while(true){
				String message  = sc.nextLine();
				print.println(message);	
//				sc.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(client != null){
				try {
					client.close();
					sc.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Client3 cli = new Client3();
		cli.start();
	}
}
