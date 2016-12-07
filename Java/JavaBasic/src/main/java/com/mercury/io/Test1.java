package com.mercury.io;
import java.io.FileOutputStream;
import java.io.*;
public class Test1 {
	public static void main(String[] args){
		int[] array = {-1, 2, 3, 4, 5, 257};
		//FileOutputStream fos = null;
		//resource?
		try(FileOutputStream fos = new FileOutputStream("resource/file1.dat");/*auto closeable*/){
			//down casting?
			//FileOutputStream fos = new FileOutputStream("resource/file1.dat");
			//fos = new FileOutputStream("resource/file1.dat");
			for(int x: array){
				fos.write(x);
			}
			
		}catch(IOException e){
			System.err.println(e);
		}/*finally{
			try{
				fos.close();
			} catch(Exception e){
				
			}
		}*/
		System.out.println("End of Main");
	}
}
