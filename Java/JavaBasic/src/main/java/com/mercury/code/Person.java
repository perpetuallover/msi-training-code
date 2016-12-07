package com.mercury.code;
//immutable class
public final class Person {
	private String name;
	public Person(){}
	public Person(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public Person addProfix(String prefix){
		return new Person(prefix + " " + name);
	}
}
