package com.nt.beans;

public class CustomerDetails {
	private String name;
	private String loction;
	private float salary;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoction() {
		return loction;
	}
	public void setLoction(String loction) {
		this.loction = loction;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "CustomerDetails [name=" + name + ", loction=" + loction + ", salary=" + salary + "]";
	}
}
