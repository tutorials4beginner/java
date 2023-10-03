package com.t4b.test;

import java.io.FileOutputStream;

public class FileOutputStreamTest {
	public static void main(String args[]) {
		try {
			FileOutputStream fout = new FileOutputStream("test.txt");
			fout.write(65);
			fout.write("Text".getBytes());
			fout.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
