package com.mercury.oop;

public class Sub3 extends Base3{

	public static void foo1(){
		System.out.println("Static foo 1 in Sub2: ");
	}
	public void foo2(){
		System.out.println("foo2 in Sub2 : ");
	}	
	public static void main(String[] args){
		Base3 b = new Sub3();
//		System.out.println(b instanceof Base3);
//		System.out.println(b instanceof Sub3);		
		b.foo1();
		Base3.foo1();
		b.foo2();
	}
}


