package com.qbq.socketoperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.ServerSocket;
import java.net.Socket;
/**
 * 
* @ClassName: Server1 
* @Description: TODO(使用Java的Socket实现客户端和服务器端之间的连接，并使客户端向服务端发送一条消息) 
* @author QianBingqiao 
* @date 2017年6月2日 下午2:58:45 
*
 */
public class Server1 {
	/**
	 * ServerSocket;
	 */
	ServerSocket server;
	
	 public Server1(){
		 try {
			server = new ServerSocket(8088);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public void start(){
		 System.out.println("等待建立连接...");
		 try {
			Socket socket = server.accept();//接受请求
		    InputStream is = socket.getInputStream();
		    InputStreamReader reader = new InputStreamReader(is,"utf-8");
		    BufferedReader buffer = new BufferedReader(reader);
		    String message = buffer.readLine();
		    System.out.println("客户端发来消息:  "+message);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	 }
	
	 public static void main(String[] args) {
		Server1  ser = new Server1();
		ser.start();
	}
}
