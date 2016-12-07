package com.mercury.oop;
//JP morgan interview question
public class Sub5 extends Base5{
	String name;
	//String name = null;
	public Sub5(){
		//this.name = super(name);
	}
	public void setName(){
		name = "Sub5";
	}
	public static void main (String[] args){
		Sub5 s = new Sub5();
		System.out.print(s.name);
		//System.out.print(super(name));
	}
}
