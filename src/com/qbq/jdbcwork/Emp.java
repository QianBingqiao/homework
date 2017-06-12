package com.qbq.jdbcwork;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 
* @ClassName: Emp 
* @Description: TODO(emp表) 
* @author QianBingqiao 
* @date 2017年6月5日 下午5:48:36 
*
 */
public class Emp implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6711901152588740613L;
	int empid;//员工ID
	String empname;//员工姓名
	String job;//职位
	int mgrid;//管理者ID
	String date;//入职日期
	double salary;//薪资
	double conn;//绩效
	int dptid;//员工所在部门ID
	
	
	public Emp() {

		// TODO Auto-generated constructor stub
	}

	public Emp(int empid, String empname, String job, int mgrid, String date, double salary, double conn, int dptid) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.job = job;
		this.mgrid = mgrid;
		this.date = date;
		this.salary = salary;
		this.conn = conn;
		this.dptid = dptid;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getConn() {
		return conn;
	}

	public void setConn(double conn) {
		this.conn = conn;
	}

	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getMgrid() {
		return mgrid;
	}
	public void setMgrid(int mgrid) {
		this.mgrid = mgrid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public int getDptid() {
		return dptid;
	}
	public void setDptid(int dptid) {
		this.dptid = dptid;
	}

	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", empname=" + empname + ", job=" + job + ", mgrid=" + mgrid + ", date=" + date
				+ ", salary=" + salary + ", conn=" + conn + ", dptid=" + dptid + "]";
	}
	
	

}
