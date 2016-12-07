package com.mercury.io;
import java.io.*;
public class Test2R {
	public static void main(String[] args){
		//13 bytes no down casting
		int x = 1234567;
		double d = 3.1415926;
		boolean b = true;
		try (FileInputStream fos = new FileInputStream("resource/file2.dat");
			BufferedInputStream buffer = new BufferedInputStream(fos); //wrapper
			DataInputStream data = new DataInputStream(buffer)){
			System.out.println("Integer: " + data.readInt());
			System.out.println("Integer: " + data.readInt());
			System.out.println("Double: " + data.readDouble());
			System.out.println("Boolean: " + data.readBoolean());
		}catch(IOException e){
			System.err.print(e);
		}
		//System.out.println("End of Main");
				
	}
}
