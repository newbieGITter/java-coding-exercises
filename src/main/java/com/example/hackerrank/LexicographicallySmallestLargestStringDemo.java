package com.example.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LexicographicallySmallestLargestStringDemo {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//		// Reading data using readLine
//		String str = reader.readLine();
//		int number = Integer.parseInt(reader.readLine());
//		//getSmallestAndLargest(str, number);
		
		int arr[] = {10, 20, 30, 20, 30};
		Arrays.stream(arr).
					distinct().forEach(System.out::println);

	}

	public static void getSmallestAndLargest(String s, int number) {
		String currString = s.substring(0, number);
		String smallest = currString;
		String largest = currString;

		for (int i = number; i < s.length(); i++) {
			currString = currString.substring(1, number) + s.charAt(i);

			if (currString.compareTo(smallest) < 0) {
				smallest = currString;
			}
			if (currString.compareTo(largest) > 0) {
				largest = currString;
			}

		}
		// Print result.
		System.out.println(smallest);
		System.out.println(largest);

	}

}
