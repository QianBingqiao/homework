package com.qbq.jdbcwork;

import java.awt.ComponentOrientation;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 
* @ClassName: JDBCDemo 
* @Description: TODO(不封装properties操作数据库) 
* @author QianBingqiao 
* @date 2017年6月5日 下午8:23:41 
*
 */
public class JDBCDemo {
	/**
	 * 查询
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void selectAll() throws ClassNotFoundException, SQLException {
		List<Emp> list = new ArrayList<Emp>();
		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "6921087");
		// 创建SQ语句
		Statement stat = conn.createStatement();
		String sql = "select * from emp";
		// 执行SQL语句
		ResultSet rs = stat.executeQuery(sql);
		// 处理结果集
		while (rs.next()) {
			Emp emp = new Emp();
			emp.setEmpid(rs.getInt("empno"));
			emp.setEmpname(rs.getString("empname"));
			emp.setJob(rs.getString("job"));
			emp.setMgrid(rs.getInt("mgr"));
			emp.setDate(String.valueOf(rs.getDate("hiredate")));
			emp.setSalary(rs.getDouble("sal"));
			emp.setConn(rs.getDouble("conn"));
			emp.setDptid(rs.getInt("deptno"));
			list.add(emp);
		}
		System.out.println(list);
		// 关闭连接
		rs.close();
		stat.close();
		conn.close();
	}
	/**
	 * 添加
	 * @param emp
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Emp add(Emp emp) throws ClassNotFoundException, SQLException {
		// Emp emp = new Emp();
		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "6921087");
		// 创建SQ语句
		Statement stat = conn.createStatement();
		String sql = "insert into emp(empno,empname,job,mgr,hiredate,sal,conn,deptno)" + "values(" + emp.getEmpid()
				+ ",'" + emp.getEmpname() + "','" + emp.getJob() + "'," + emp.getMgrid() + ",'" + emp.getDate() + "',"
				+ emp.getSalary() + "," + emp.getConn() + "," + emp.getDptid() + ");";
		// 执行SQL语句
		boolean b =stat.execute(sql);
		// 处理结果集
		if(stat !=null){
			stat.close();}
		if(conn != null){
			conn.close();
		}
		return emp;
	}
	/**
	 * 删除
	 * @param empid
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void delete(int empid) throws ClassNotFoundException, SQLException {
		// Emp emp = new Emp();
		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "6921087");
		// 创建SQ语句
		Statement stat = conn.createStatement();
		String sql = "delete from emp where empno=" + empid +";";
		// 执行SQL语句
		stat.executeUpdate(sql);
		//关闭连接
		if(stat !=null){
			stat.close();}
		 if(conn != null){
			conn.close();
		}
	}
	/**
	 * 修改，按条件修改
	 * @param id
	 * @param name
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void modify(int id,String name) throws ClassNotFoundException, SQLException {
		// Emp emp = new Emp();
		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "6921087");
		// 创建SQ语句
		Statement stat = conn.createStatement();
		String sql = "update emp set empname = '" + name + "' where empno =" + id + ";";
		// 执行SQL语句
		stat.executeUpdate(sql);
		//关闭连接
		if(stat !=null){
			stat.close();}
		 if(conn != null){
			conn.close();
		}
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		JDBCDemo demo = new JDBCDemo();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		Emp emp = new Emp();
//		 demo.add(new Emp(1, "zhangsan", "java工程师", 101, str, 50000, 3000,
//				10));
//		 demo.add(new Emp(2, "zhangsan", "java工程师", 102, str, 60000, 5000,
//					10));
//		 demo.add(new Emp(3, "wangwu", "java工程师", 103, str, 70000, 8000,
//					10));
//		demo.selectAll();
//		demo.modify(1, "lisi");
		demo.delete(3);
	}

}
