package com.t4b.test;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) {
		FileInputStream fin;
		try {
			fin = new FileInputStream("test.txt");
			int i = fin.read();
			System.out.print((char) i);
			fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
