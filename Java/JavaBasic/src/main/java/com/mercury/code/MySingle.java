package com.mercury.code;
//Lazy Model of Singleton: singleton is very useful when object is very big
public class MySingle {
	// must can write the code
	// thread safe, memory, performance
	//2 must be static 
	//create instance is different from modify
	private static /*volatile*/ MySingle instance /* = new MySingle()?*/;
	private MySingle(){
		System.out.println("Create an instance of MySingle");
	}
	/*synchroized*/public static MySingle getIntance(){
		if(instance == null){//introduced in 2011, double layer check
			synchronized(MySingle.class){
				if(instance == null){
					instance = new MySingle();
				}
			}
		}		
		return instance;
	}
}
