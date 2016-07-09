package com.hybrid.model;

import java.util.Date;

public class Emp {
	int empno;
	String ename;
	String job;
	Integer mgr;
	Date hiredate;
	Double sal;
	Double comm;
	Integer deptno;
	
	@Override
	public String toString() {
		String rtn;
//		rtn = empno + "\t";
//		rtn += ename + "\t";
//		rtn += job + "\t";
//		rtn += mgr + "\t";
//		rtn += hiredate + "\t";
//		rtn += sal + "\t";
//		rtn += comm + "\t";
//		rtn += deptno + "\t";
		
		rtn = String.format("%4d %20s %10s %4d %s %10.1f %10.1f %2d", 
							empno, ename, job, mgr, hiredate, sal, comm, deptno);

		return rtn;
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getMgr() {
		return mgr;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Double getComm() {
		return comm;
	}
	public void setComm(Double comm) {
		this.comm = comm;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	
}
