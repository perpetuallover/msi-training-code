package com.mercury.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Test4 {
	public static void main(String[] args){
		try(FileOutputStream fos = new FileOutputStream("resource/file4.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			Login data = new Login("alice", "abcde");// not only fields but the whole object(method definition)
			oos.writeObject(data);
		}catch(IOException e){
			System.err.println(e);
		}
		System.out.println("End of Main");
	}
}
