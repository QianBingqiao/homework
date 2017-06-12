package com.qbq.socketoperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @ClassName: Server3
 * @Description: TODO(在Server2的基础上使用线程来处理多个客户端的信息,并且接收的时候用while循环)
 * @author QianBingqiao
 * @date 2017年6月2日 下午4:16:01
 *
 */
public class Server3 {
	/**
	 * ServerSocket;
	 */
	ServerSocket server;

	public Server3() {
		try {
			server = new ServerSocket(8088);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//
	public void start() {
		
		try {
			while(true){	
				System.out.println("等待建立连接...");
				Socket socket = server.accept();// 接受请求
				System.out.println("已经连接了...");
				new Thread(new ClientHandler(socket)).start();
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// 使用线程来实现一个服务器端可以同时接收多个客户端的信息
	class ClientHandler implements Runnable {
		Socket sockets;
		InputStream is;

		public ClientHandler(Socket sockets) {
			super();
			this.sockets = sockets;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				is = sockets.getInputStream();
				InputStreamReader reader = new InputStreamReader(is, "utf-8");
				BufferedReader buffer = new BufferedReader(reader);
				while (true) {
					String message = buffer.readLine();
					System.out.println("客户端发来消息:  " + message);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		Server3 ser = new Server3();
		ser.start();
	}
}
