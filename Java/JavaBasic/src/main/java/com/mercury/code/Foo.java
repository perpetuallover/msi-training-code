package com.mercury.code;

public class Foo extends Outer.B{
	public Foo(Outer outer){
		outer.super(); // create Outer.B in order to create Foo
	}
	public Foo(){
		new Outer().super();
	}
}
