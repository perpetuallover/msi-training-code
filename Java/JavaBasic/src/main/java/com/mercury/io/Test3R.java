package com.mercury.io;
import java.io.*;
public class Test3R {
	public static void main(String[] args){
		try(FileInputStream fis = new FileInputStream("resource/file3.dat");
			ObjectInputStream ois = new ObjectInputStream(fis)){
			Data data = (Data)ois.readObject();
			System.out.println("Integer: " + data.getX());
			System.out.println("Double: " + data.getD());
			System.out.println("Boolean: " + data.isB());
		}catch (IOException | ClassNotFoundException e){
			System.err.println(e);
		}
		
	}
}
