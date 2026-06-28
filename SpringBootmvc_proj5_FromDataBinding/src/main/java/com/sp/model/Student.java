package com.sp.model;

public class Student {
	private Integer sno;
	private String sname;
	private String saddr;
	private float savg;	
	
	public Student()
	{
		System.out.println("student.student()");
	}
	
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddr() {
		return saddr;
	}
	public void setSaddr(String saddr) {
		this.saddr = saddr;
	}
	public float getSavg() {
		return savg;
	}
	public void setSavg(float savg) {
		this.savg = savg;
	}
	
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", saddr=" + saddr + ", savg=" + savg + "]";
	}
}