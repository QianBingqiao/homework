package com.qbq.iooperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ExceptionOperation {
	People people;
	/**
	 * 1）制造空指针异常NullPointerException;
	 */
	public void  nullPointerExceptionTest(){
		List<People> list = new ArrayList<People>();
		list.add(people);
		System.out.println(list.get(0).name);
	//java.lang.NullPointerException
	
		System.out.println(people.toString());
	}
	/**
	 * 2）制造数组越界异常ArrayIndexOutOfBoundsException;
	 */
	public void arrayIndexOutOfBoundsExceptionTest(){
		String [] arr = new String[0];
		System.out.println(arr[1]);
		//java.lang.ArrayIndexOutOfBoundsException
	}
	/**
	 * 3）制造数学异常ArithmeticException；
	 */
	public void arithmeticExceptionTest(){
		int a;
		a = 5/0;
		System.out.println(a);
		//java.lang.ArithmeticException
	}
	/**
	 * 4）制造强制类型转换异常ClassCastException;
	 */
	public void classCastException(){
		Object a = new Integer(0);
		String str = (String) a;
		System.out.println(str);
		// java.lang.ClassCastException
	}
	/**
	 * 5）制造数值格式化异常NumberFormatException；
	 * @throws IOException
	 */
	public void numberFormatExceptionTest() throws IOException{
	    String numString = "1 ";
	   System.out.println(Integer.parseInt(numString));
	   //java.lang.NumberFormatException
	}
	public static void main(String[] args) throws IOException {
		ExceptionOperation operation  =new ExceptionOperation();
//		operation.nullPointerExceptionTest();
//		operation.arrayIndexOutOfBoundsExceptionTest();
//		operation.arithmeticExceptionTest();
//		operation.classCastException();
//		operation.numberFormatExceptionTest();
	}
	class People{
		String name;
		int age;
		@Override
		public String toString() {
			return "People [name=" + name + ", age=" + age + "]";
		}
		
	}
}
