package com.qbq.iooperation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


/**
 * 
 * @author QianBingqiao @date 2017年5月27日 14:35:54 @category
 */
public class IOOperation {
	/**
	 * 
	 * @throws IOException
	 */
	public void javaIOTest() throws IOException {
		// ①如果“javaio.txt”文件不存在则创建该文件；
		FileOutputStream output = new FileOutputStream("javaio.txt");
		// ②使用OutputStreamWriter时指定字符集为"UTF-8"。
		OutputStreamWriter writer = new OutputStreamWriter(output, "utf-8");
		PrintWriter print = new PrintWriter(writer, true);
		print.println("这是Java字符io操作练习题");
//		print.flush();
		FileInputStream input = new FileInputStream("javaio.txt");
		// ③用InputStreamReader对象的read方法读取“javaio.txt”文件，并输出到控制台中。
		InputStreamReader reader = new InputStreamReader(input, "utf-8");
		int length = -1;
		while ((length = reader.read()) != -1) {
			System.out.print((char) length + "");
		}
		// ④用PrintWriter对象的print方法写入"这是PrintWriter !"；在用println方法写入"这是
		// PrintWriter的print方法!"。比较这2个方法有什么区别。
		print.print("这是PrintWriter !");
		print.println("这是PrintWriter的print方法!");
		// 区别：println方法在输出目标数据后，自动输出一个系统支持的换行符
		
		print.close();
		reader.close();
//		buffer.close();
	}
	public void testBufferedReader() throws IOException{
		FileInputStream input = new FileInputStream("javaio.txt");
		//⑤用BufferedReader的readLine方法读取“javaio.txt”文件的内容，并显示到控制台中
		InputStreamReader reader = new InputStreamReader(input, "utf-8");
		BufferedReader buffer = new BufferedReader(reader);
		String value = null;
		while ((value = buffer.readLine()) != null) {
			System.out.println(value);
		}
		buffer.close();
	}

	public static void main(String[] args) throws IOException {
		IOOperation io = new IOOperation();
//		io.javaIOTest();
//		io.testBufferedReader();
	}
}
