package com.example.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaStaticInitializerBlockDemo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine
		int breadth = Integer.parseInt(reader.readLine());
		int height = Integer.parseInt(reader.readLine());
		
		if(breadth < 0 || height < 0 ) {
			System.out.println("java.lang.Exception: Breadth and height must be positive");
		} else {
			System.out.println(breadth * height);
		}
	}

}
