package com.mercury.code;

public class Employee implements Cloneable {
	private String name;
	public Employee(){}
	public Employee(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Employee clone() throws CloneNotSupportedException{
		return (Employee)super.clone();
	}
}
