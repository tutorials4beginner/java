package com.t4b.test;

import java.io.FileInputStream;
import java.io.SequenceInputStream;

public class SequenceInputStreamTest {

	public static void main(String[] args) {
		try {
			FileInputStream fileInputStream1 = new FileInputStream("testin.txt");
			FileInputStream fileInputStream2 = new FileInputStream("testout.txt");
			SequenceInputStream inst = new SequenceInputStream(fileInputStream1, fileInputStream2);
			int j;
			while ((j = inst.read()) != -1) {
				System.out.print((char) j);
			}
			inst.close();
			fileInputStream1.close();
			fileInputStream2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
