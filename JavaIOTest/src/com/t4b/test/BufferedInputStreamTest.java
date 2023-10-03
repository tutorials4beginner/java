package com.t4b.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamTest {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("test.txt");
			BufferedInputStream bin = new BufferedInputStream(fin);
			int i;
			while ((i = bin.read()) != -1) {
				System.out.print((char) i);
			}
			bin.close();
			fin.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
