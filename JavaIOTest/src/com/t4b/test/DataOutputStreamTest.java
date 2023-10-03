package com.t4b.test;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamTest {

	public static void main(String[] args) {
		try {
			FileOutputStream file = new FileOutputStream("test.txt");
			DataOutputStream data = new DataOutputStream(file);
			data.writeInt(100);
			data.flush();
			data.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
