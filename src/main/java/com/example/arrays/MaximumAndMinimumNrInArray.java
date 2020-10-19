package com.example.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MaximumAndMinimumNrInArray {

	// Input:
	// On Line 1: Enter nr of test cases you want to send. For instance: 2 -- This
	// infers that we should insert 2 arrays of numbers on subsequent lines
	// On Line 2: Array number 1. For instance:  23 24 44 55 66 65 47 4 88
	// On LIne 3: Array number 2. For instance: 244 211 111 45 56 67 777 5 66
	
	// Output: 
	// Smallest number in the array is: 4
	// Largest number in the array is: 88
	// Smallest number in the array is: 5
	// Largest number in the array is: 777

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int nrOfTestCases = Integer.parseInt(reader.readLine());
		Map<Integer, String[]> mapOfCounterWithArray = new LinkedHashMap<>();

		for (int i = 0; i < nrOfTestCases; i++) {
			String[] readLine = reader.readLine().split(" ");
			mapOfCounterWithArray.put(i + 1, readLine);
		}
		mapOfCounterWithArray.forEach((key, value) -> {
			System.out.print("key: " + key + " Value: ");
			Stream.of(value).forEach(s -> System.out.print(s + " "));
		});
		findMinAndMaxNumberInArray(mapOfCounterWithArray);
	}

	private static void findMinAndMaxNumberInArray(Map<Integer, String[]> mapOfCounterWithArray) {
		System.out.println("======================");
		System.out.println("====findMinAndMaxNumberInArray======");
		mapOfCounterWithArray.forEach((key, value) -> {
			int largest = Integer.parseInt(value[0]);
			int smallest = Integer.parseInt(value[0]);
			for (String num : value) {
				int nr = Integer.parseInt(num);

				if (nr > largest) {
					largest = nr;
				} else if (nr < smallest) {
					smallest = nr;
				}
			}
			System.out.println("Smallest number in array number " + key + " is: " + smallest);
			System.out.println("Largest number in array number " + key + " is: " + largest);
		});
	}

}
