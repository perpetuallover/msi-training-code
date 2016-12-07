package com.mercury.io;
import java.io.*;
public class Test3 {
	public static void main(String[] args){
		try(FileOutputStream fos = new FileOutputStream("resource/file3.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			Data data = new Data(1234567, 3.1415926, true);// not only fields but the whole object(method definition)
			oos.writeObject(data);
		}catch(IOException e){
			System.err.println(e);
		}
		System.out.println("End of Main");
	}
}
