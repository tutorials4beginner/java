package com.t4b.test;

import java.io.FileReader;

public class FileReaderTest {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("test.txt");
			int i;
			while ((i = fr.read()) != -1)
				System.out.print((char) i);
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
