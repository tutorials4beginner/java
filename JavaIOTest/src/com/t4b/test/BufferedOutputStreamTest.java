package com.t4b.test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamTest {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("test.txt");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			String s = "Hello World!";
			byte b[] = s.getBytes();
			bout.write(b);
			bout.flush();
			bout.close();
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
