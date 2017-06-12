package com.qbq.jdbcwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * 
* @ClassName: DBOperation 
* @Description: TODO(这封装properties操作数据库) 
* @author QianBingqiao 
* @date 2017年6月5日 下午8:27:58 
*
 */
public class DBOperation {
	/**
	 * 查询
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void selectAll() throws ClassNotFoundException, SQLException {
		List<Emp> list = new ArrayList<Emp>();
		Connection conn =DBUnity.openConnection();
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

		//关闭连接
		DBUnity.closeConnection(conn);
	}
	/**
	 * 添加
	 * @param emp
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Emp add(Emp emp) throws ClassNotFoundException, SQLException {
		// 加载驱动
		Connection conn =DBUnity.openConnection();
		// 创建SQ语句
		Statement stat = conn.createStatement();
		String sql = "insert into emp(empno,empname,job,mgr,hiredate,sal,conn,deptno)" + "values(" + emp.getEmpid()
				+ ",'" + emp.getEmpname() + "','" + emp.getJob() + "'," + emp.getMgrid() + ",'" + emp.getDate() + "',"
				+ emp.getSalary() + "," + emp.getConn() + "," + emp.getDptid() + ");";
		// 执行SQL语句
		stat.execute(sql);
		// 处理结果集
		//关闭连接
		DBUnity.closeConnection(conn);
		return emp;
	}
	/**
	 * 删除
	 * @param empid
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void delete(int empid) throws ClassNotFoundException, SQLException {
		// 加载驱动
		Connection conn =DBUnity.openConnection();
		// 创建SQ语句
		Statement stat = conn.createStatement();
		String sql = "delete from emp where empno=" + empid +";";
		// 执行SQL语句
		stat.executeUpdate(sql);
		//关闭连接
		DBUnity.closeConnection(conn);
	}
	/**
	 * 修改，按条件修改
	 * @param id
	 * @param name
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void modify(int id,String name) throws ClassNotFoundException, SQLException {
		// 加载驱动
		Connection conn =DBUnity.openConnection();
		Statement stat = conn.createStatement();
		String sql = "update emp set empname = '" + name + "' where empno =" + id + ";";
		// 执行SQL语句
		stat.executeUpdate(sql);
		//关闭连接
		DBUnity.closeConnection(conn);
	}

}
