package com.t4b.test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamTest {
	public static void main(String[] args) {
		try {
			FileOutputStream fos1 = new FileOutputStream("test1.txt");
			FileOutputStream fos2 = new FileOutputStream("test2.txt");

			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			bout.write(100);
			bout.writeTo(fos1);
			bout.writeTo(fos2);

			bout.flush();
			bout.close();
			
			fos1.close();
			fos2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
