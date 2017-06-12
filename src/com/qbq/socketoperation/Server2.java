package com.qbq.socketoperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
* @ClassName: Server2 
* @Description: TODO(在Server1的基础上用while(true){}实现不断接收客户端发出的消息) 
* @author QianBingqiao 
* @date 2017年6月2日 下午3:58:58 
*
 */
public class Server2 {
	/**
	 * ServerSocket;
	 */
	ServerSocket server;
	
	 public Server2(){
		 try {
			server = new ServerSocket(8088);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	// 实现客户端重复发送数据到服务器端的功能。即，用户可以在控制台不断输入内容，并将内容逐一发送给服务端。
	 public void start(){
		 System.out.println("等待建立连接...");
		 try {
			Socket socket = server.accept();//接受请求
			System.out.println("已经连接了...");
		    InputStream is = socket.getInputStream();
		    InputStreamReader reader = new InputStreamReader(is,"utf-8");
		    BufferedReader buffer = new BufferedReader(reader);
		    while(true){
		    	String message = buffer.readLine();
		    	System.out.println("客户端发来消息:  "+message);
		    }
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	 }
	
	 public static void main(String[] args) {
		Server2  ser = new Server2();
		ser.start();
	}
}
