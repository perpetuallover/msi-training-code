package com.mercury.io;
import java.io.*;
public class Test4R {
	public static void main(String[] args){
		try(FileInputStream fis = new FileInputStream("resource/file4.dat");
			ObjectInputStream ois = new ObjectInputStream(fis)){
			Login login = (Login)ois.readObject();
			System.out.println("Integer: " + login.getUsername());
			System.out.println("Double: " + login.getPassword());
		}catch (IOException | ClassNotFoundException e){
			System.err.println(e);
		} // child class exception?
	// create new then read	
	}
}
