package com.qbq.socketoperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 
 * @ClassName: Client4
 * @Description: TODO(使服务端可以将用户的信息转发给所有客户端，并在每个客户端控制台上显示,在Client3的基础上加一个线程去接收从 服务器上发出来的数据，显示)
 * @author QianBingqiao
 * @date 2017年6月2日 下午4:33:44
 *
 */
public class Client4 {
	/**
	 * Socket
	 */
	Socket client;
	Scanner sc;

	public Client4() {
		try {
			client = new Socket("localhost", 8088);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void start() {
		try {
			ServerHandler handler = new ServerHandler();
			Thread thread = new Thread(handler);
			thread.setDaemon(true);
			thread.start();
			sc = new Scanner(System.in);
			OutputStream os = client.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(os, "utf-8");
			PrintWriter print = new PrintWriter(writer, true);
			while (true) {
				String message = sc.nextLine();
				print.println(message);
				// sc.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (client != null) {
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

	class ServerHandler implements Runnable {
		InputStream is;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				is = client.getInputStream();
				InputStreamReader reader = new InputStreamReader(is, "utf-8");
				BufferedReader buffer = new BufferedReader(reader);
				while (true) {
					String message = buffer.readLine();
					System.out.println(message);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		Client4 cli = new Client4();
		cli.start();
	}

}
