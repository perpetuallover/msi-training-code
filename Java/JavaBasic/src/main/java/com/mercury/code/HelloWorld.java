package com.mercury.code;
// static will excute first
public class HelloWorld {
	private static String str = "Hello World";
	public static void main(String[] args){
		System.out.println(str);
	}
	static {
		System.out.println(str);
		str = "Hello Bob";
	}
	public String hello(){
		class Local {
			String foo(){
				return "A";
			}
		}
		Local local = new Local();
		return local.foo();
	}
}
