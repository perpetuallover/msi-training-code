package com.mercury.io;
import java.io.*;
public class Test1R {
	public static void main(String[] args){
		try(FileInputStream fis = new FileInputStream("resource/file1.dat");){			
			int x = fis.read();
			while(x != -1){//? -1 end sign, is always positive
				System.out.println(x);
				x = fis.read();
			}
		} catch (IOException e){ //lazy coding.. use Exception; industry use detailed exception
			System.err.println(e);
		}
		// read and write can only use byte which will lose data
	}
}
