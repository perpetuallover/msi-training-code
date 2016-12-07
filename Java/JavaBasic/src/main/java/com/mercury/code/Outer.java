package com.mercury.code;

public class Outer {
	private int x = 10; 
	//class variable: like friend class in C++, could access all the fields in the outer class
	public static class A { // static inner class
		public String foo(){
			return "foo in A";
		}
	}
	public class B { //member variable
		public String foo(){ // non-static inner class
			return "foo in B";
		}
		public int getX(){
			return x;
		}
	}
	//local variable must be initialized
	public String hello(){
		class Local {
			String foo(){
				return "Local";
			}
		}
		Local local = new Local();
		return local.foo();
	}
	//Anonymous inner class
	//practice
	public Cloneable c = new Cloneable(){
		@Override	
		public String toString() {
			return "c";
		}
	};
	//obj is sub class
	public Object obj = new Object(){
		@Override
		public String toString(){
			return "obj";
		}
	};
	
}
