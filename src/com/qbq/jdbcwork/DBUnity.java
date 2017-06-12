package com.qbq.jdbcwork;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 
* @ClassName: DBUnity 
* @Description: TODO(封装properties) 
* @author QianBingqiao 
* @date 2017年6月5日 下午8:14:36 
*
 */
public class DBUnity {
	private static Properties properties = new Properties();
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	//静态代码块
	static{
		try {
			properties.load(DBUnity.class.getClassLoader().
					getResourceAsStream("resource/jdbc.properties"));
			driver = properties.getProperty("jdbc.driverClassName");
			url = properties.getProperty("jdbc.url");
			username = properties.getProperty("jdbc.username");
			password = properties.getProperty("jdbc.password");
			Class.forName(driver);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection openConnection() throws SQLException{
		return DriverManager.getConnection(url,username,password);
	}
	public static void closeConnection(Connection conn){
		if(conn!= null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("关闭连接时发生异常");
			}
		}
	}
}
