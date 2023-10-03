package com.t4b.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {

	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("test.txt");
			PrintStream pout = new PrintStream(fout);
			pout.println(2016);
			pout.println("Hello World");
			pout.close();
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
