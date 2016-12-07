package com.mercury.code;

public class TestMySingle2 {
	public static void main(String[] args){
		for(int i = 0; i < 10; i++){
			new Thread(){
				@Override
				public void run(){
					MySingle.getIntance();
				}
			}.start();
		}
	}
}
