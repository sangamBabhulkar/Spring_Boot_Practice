package com.nt.model;

public class Actor {
	
	private Integer id;
	private String name;
	private String address;
	private Float fees;
	public Actor(Integer id, String name, String address, Float fees) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.fees = fees;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Float getFees() {
		return fees;
	}
	public void setFees(Float fees) {
		this.fees = fees;
	}
}
