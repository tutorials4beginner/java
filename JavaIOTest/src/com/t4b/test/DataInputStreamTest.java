package com.t4b.test;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class DataInputStreamTest {

	public static void main(String[] args) {
		try {
			InputStream input = new FileInputStream("test.txt");
			DataInputStream dinst = new DataInputStream(input);
			int count = input.available();
			byte[] ary = new byte[count];
			dinst.read(ary);
			for (byte bt : ary) {
				char k = (char) bt;
				System.out.print(k + "-");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
