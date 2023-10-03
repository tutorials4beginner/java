package com.t4b.test;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamTest {

	public static void main(String[] args) {
		byte[] buf = { 10, 20, 30, 25 };
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buf);
		int k = 0;
		while ((k = byteArrayInputStream.read()) != -1) {
			char ch = (char) k;
			System.out.println("ASCII value of " + ch + " is : " + ch);
		}
	}
}
