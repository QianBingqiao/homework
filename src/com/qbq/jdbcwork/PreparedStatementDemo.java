package com.qbq.jdbcwork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 使用封装好的DBUtility ，使用PreparedStatement实现对Emp数据的添加，修改（指定id,修改其余信息）查询（指定id进行删除）（Mysql）
 * @ClassName: PreparedStatementDemo
 * @Description: TODO(PreparedStatement通过jdbc连接数据库，进行增删改查，防止sql注入漏洞)
 * @author QianBingqiao
 * @date 2017年6月6日 下午12:29:10
 *
 */
public class PreparedStatementDemo {
	/**
	 * 添加数据 emp
	 * @param emp
	 * @throws SQLException
	 */
	public void addPrepared(Emp emp) throws SQLException {
		// Date date = new Date();
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// String strdate = sdf.format(date);
		// 加载驱动
		Connection conn = DBUnity.openConnection();
		// 创建语句对象
		String sql = "insert into emp(empno,empname,job,mgr,hiredate,sal,conn,deptno)" + "values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, emp.getEmpid());
		ps.setString(2, emp.getEmpname());
		ps.setString(3, emp.getJob());
		ps.setInt(4, emp.getMgrid());
		ps.setDate(5, (java.sql.Date) new Date());
		ps.setDouble(6, emp.getSalary());
		ps.setDouble(7, emp.getConn());
		ps.setInt(8, emp.getDptid());
		// 执行sql语句
		int z = ps.executeUpdate();
		// 处理结果集
		if (z > 1) {
			System.out.println("添加数据成功");
		} else {
			System.out.println("添加数据失败");
		}
		// 关闭连接
		if (ps != null) {
			ps.close();
		}
		DBUnity.closeConnection(conn);
	}

	/**
	 * 修改emp对象
	 * 
	 * @param emp
	 * @return
	 * @throws SQLException
	 */
	public Emp modifyPrepared(Emp emp) throws SQLException {
		// Date date = new Date();
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// String strdate = sdf.format(date);
		// 加载驱动
		Connection conn = DBUnity.openConnection();
		// 创建语句对象
		String sql = "update emp set empname=?,job=?,mgr=?,hiredate=?,sal=?,conn=?,deptno=? where empno =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		// ps.setInt(1, emp.getEmpid());
		ps.setString(1, emp.getEmpname());
		ps.setString(2, emp.getJob());
		ps.setInt(3, emp.getMgrid());
		ps.setDate(4, (java.sql.Date) new Date());
		ps.setDouble(5, emp.getSalary());
		ps.setDouble(6, emp.getConn());
		ps.setInt(7, emp.getDptid());
		ps.setInt(8, emp.getEmpid());
		// 执行sql语句
		int z = ps.executeUpdate();
		// 处理结果集
		if (z > 1) {
			System.out.println("添加数据成功");
		} else {
			System.out.println("添加数据失败");
		}
		// 关闭连接
		if (ps != null) {
			ps.close();
		}
		DBUnity.closeConnection(conn);
		return emp;
	}
	/**
	 * 全部查询
	 * @return emp的list对象
	 * @throws SQLException
	 */
	public List<Emp> selectAll() throws SQLException {
		List<Emp> list = new ArrayList<Emp>();
		// 加载驱动
		Connection conn = DBUnity.openConnection();
		// 创建语句对象
		String sql = "select * from emp";
		PreparedStatement ps = conn.prepareStatement(sql);
		// 执行sql语句
		ResultSet rs = ps.executeQuery();
		// 处理结果集
		while (rs.next()) {
			Emp emp = new Emp();
			emp.setEmpid(rs.getInt("empno"));
			emp.setEmpname(rs.getString("empanme"));
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
		if (ps != null) {
			ps.close();
		}
		DBUnity.closeConnection(conn);
		return list;
	}
	/**
	 * 精确查找某一条数据
	 * @param id empno,通过ID来查询当前ID所在位置的数据
	 * @return
	 * @throws SQLException
	 */
	public Emp selectEmpno(int id) throws SQLException {
		Emp emp = new Emp();
		// 加载驱动
		Connection conn = DBUnity.openConnection();
		// 创建语句对象
		String sql = "select * from emp where empno=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		// 执行sql语句
		ResultSet rs = ps.executeQuery();
		// 处理结果集
		if(rs !=null){
			emp.setEmpid(rs.getInt("empno"));
			emp.setEmpname(rs.getString("empanme"));
			emp.setJob(rs.getString("job"));
			emp.setMgrid(rs.getInt("mgr"));
			emp.setDate(String.valueOf(rs.getDate("hiredate")));
			emp.setSalary(rs.getDouble("sal"));
			emp.setConn(rs.getDouble("conn"));
			emp.setDptid(rs.getInt("deptno"));
			return emp;
		}
		//关闭连接
			rs.close();
		if (ps != null) {
			ps.close();
		}
		DBUnity.closeConnection(conn);
		return null;
	}
	/**
	 * 删除其中一条数据,通过empno
	 * @param id 通过ID删除某一条数据
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteEmpno(int id) throws SQLException {
		// 加载驱动
		Connection conn = DBUnity.openConnection();
		// 创建语句对象
		String sql = "delete from emp where empno=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		// 执行sql语句
		boolean rs = ps.execute();
		// 处理结果集
		if(rs){
			System.out.println("删除成功！");
			return true;
		}
		// 关闭连接
		if (ps != null) {
			ps.close();
		}
		DBUnity.closeConnection(conn);
		System.out.println("删除失败！");
		return false;
	}

}
