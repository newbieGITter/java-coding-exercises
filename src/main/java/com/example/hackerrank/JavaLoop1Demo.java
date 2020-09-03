package com.example.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaLoop1Demo {

	// Sample input
	// 2

	// Sample output:
	// 2 x 1 = 2
	// 2 x 2 = 4
	// 2 x 3 = 6
	// 2 x 4 = 8
	// 2 x 5 = 10
	// 2 x 6 = 12
	// 2 x 7 = 14
	// 2 x 8 = 16
	// 2 x 9 = 18
	// 2 x 10 = 20

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int input = Integer.valueOf(reader.readLine());

		if (input >= 2 && input <= 20) {
			for (int i = 1; i <= 10; i++) {
				System.out.println(input + " x " + i + " = " + input * i);
			}
		} else {
			System.out.println("Input number should be between 2 & 20.");
		}

	}

}
