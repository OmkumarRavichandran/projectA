package com.chainsys.projectA.beans;

public class Employee {

	private int id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void print () {
		System.out.println(this.getId());
		System.out.println(this.getName());
	}
}
