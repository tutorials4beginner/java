package com.t4b.test;

import java.io.FileWriter;

public class FileWriterTest {

	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("test.txt");
			fw.write("Hello World!");
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
