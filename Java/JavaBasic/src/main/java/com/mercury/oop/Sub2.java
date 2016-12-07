package com.mercury.oop;

public class Sub2 extends Base2{
	public Sub2(String str){
		//super(str);
		System.out.println("Sub2 in " + str);
	}
	public static void main(String[] args){
		new Sub2("foo");
	}
}
