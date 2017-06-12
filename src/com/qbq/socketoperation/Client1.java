package com.qbq.socketoperation;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * 
* @ClassName: Client1 
* @Description: TODO(使用Java的Socket实现客户端和服务器端之间的连接，并使客户端向服务端发送一条消息) 
* @author QianBingqiao 
* @date 2017年6月2日 下午3:46:34 
*
 */
public class Client1 {
	/**
	 * Socket
	 */
	Socket client;
	
	public Client1(){
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
	//
	public void start(){
		try {
			OutputStream os = client.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(os, "utf-8");
			PrintWriter print = new PrintWriter(writer,true);
			print.println("你好服务器");	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(client != null){
				try {
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Client1 cli = new Client1();
		cli.start();
	}
	
	
	

}
