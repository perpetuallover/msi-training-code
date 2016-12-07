package com.kenny.beans;

public class CollatzConjecture {
	public void process(int n){
		System.out.println("Before n: " + n);
		while(n != 1){
			if(n % 2 == 0){
				n /= 2;
			}else{
				n = n * 3 + 1;
			}
		}
		System.out.println("After n: " + n);
		System.out.println("===============================");
	}
	public static void main(String[] args){
		CollatzConjecture cc = new CollatzConjecture();
		cc.process(13);
		cc.process(88);
		cc.process(109);
	}
}
