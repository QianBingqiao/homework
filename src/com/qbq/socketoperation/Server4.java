package com.qbq.socketoperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;



/**
 * 
* @ClassName: Server4 
* @Description: TODO(在Server3的基础上，用List<PrintWriter>数组保存从每个客户端发来的数据，并发送到所有客户端)
* 使服务端可以将用户的信息转发给所有客户端，并在每个客户端控制台上显示 
* @author QianBingqiao 
* @date 2017年6月2日 下午4:33:37 
*
 */
public class Server4 {
	/**
	 * ServerSocket;
	 */
	ServerSocket server;
	List<PrintWriter> list;

	public Server4() {
		try {
			server = new ServerSocket(8088);
			list = new ArrayList<PrintWriter>();
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
				OutputStream os = sockets.getOutputStream();
				OutputStreamWriter writer = new OutputStreamWriter(os,"utf-8");
				PrintWriter print = new PrintWriter(writer,true);
				list.add(print);
				is = sockets.getInputStream();
				InputStreamReader reader = new InputStreamReader(is, "utf-8");
				BufferedReader buffer = new BufferedReader(reader);
				int port = sockets.getPort();
				while (true) {
					String message = buffer.readLine();
					for(PrintWriter pri:list){
						pri.println("客户端发来消息:  " +"端口号: " + port  +"内容: "+ message);
					}
//					System.out.println("客户端发来消息:  " + message);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		Server4 ser = new Server4();
		ser.start();
	}
}
