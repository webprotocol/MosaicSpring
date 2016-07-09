package com.hybrid.model;

public class Dept {
	Integer deptno;
	String dname;
	String loc;
	
	@Override
	public String toString() {
		
		return String.format("%5d %10s %10s", deptno, dname, loc);
	}
	
	public Dept() {
	}
	
	public Dept(Integer deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	

}
