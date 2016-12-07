package com.mercury.oop;

public class Sub4 extends Base4{
	int x = 5;
	public void foo(){
		System.out.println(x + " in Sub");
	}
	public Sub4(){
		foo();
	}
	public static void main(String[] args){
		new Sub4();
	}
	
}
