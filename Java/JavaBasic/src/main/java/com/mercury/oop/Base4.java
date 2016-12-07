package com.mercury.oop;

public class Base4 {
	int x = 3;
	//object will be created in the heap
	//functions dont need initialization they are in the heap
	//fields need initialize
	public void foo(){
		System.out.println(x + " in Base");
	}
	//filed do not have override
//	private void foo(){
//		System.out.println(x + " in Base");
//	}
	public Base4(){
		foo();
	}
}
