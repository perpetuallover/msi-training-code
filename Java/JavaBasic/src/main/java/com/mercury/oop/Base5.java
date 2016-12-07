package com.mercury.oop;

public class Base5 {
	String name = null; //default null
	public void setName(){
		System.out.println("executed");
		name = "Base5";
	}
	public Base5(){
		setName();
	}
}
