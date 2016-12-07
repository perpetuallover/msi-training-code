package com.mercury.io;
import java.io.*;
public class Test2 {
	public static void main(String[] args){
		//13 bytes no down casting
		int x = 1234567;
		double d = 3.1415926;
		boolean b = true;
		try (FileOutputStream fos = new FileOutputStream("resource/file2.dat");
			BufferedOutputStream buffer = new BufferedOutputStream(fos);
			DataOutputStream data = new DataOutputStream(buffer)){
			data.writeInt(x);
			data.writeInt(-11111);
			data.writeDouble(d);
			data.writeBoolean(b);
		}catch(IOException e){
			System.err.print(e);
		}
		System.out.println("End of Main");
				
	}
}
