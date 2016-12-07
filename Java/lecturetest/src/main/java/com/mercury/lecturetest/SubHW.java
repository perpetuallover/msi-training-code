package com.mercury.lecturetest;

public class SubHW extends HelloWorld{
	int x = 20;
	public static void main(String[] args){
		HelloWorld p = new SubHW();
		System.out.println(p.x);
		SubHW q = new SubHW();
		System.out.println(q.x);
	}
}
