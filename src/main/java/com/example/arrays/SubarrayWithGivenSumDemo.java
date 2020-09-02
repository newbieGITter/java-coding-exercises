package com.example.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SubarrayWithGivenSumDemo {

	// Input:
	// nrOfTestCases: 2
	// First int represents nr of Elements and second int represents the sum: 8 23
	// Elements in the array. Make sure nr of elements is equal to what is given in
	// above line: 15 2 4 8 9 5 10 23
	// 2nd Test case begins: 6 15
	// Elements of second array: 3 5 2 1 3 1

	// Output:
	// Sum found between indexes 1 and 4
	// Sum found between indexes 0 and 5
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int nrOfTestCases = Integer.parseInt(reader.readLine());
		Map<Integer, String> inputMap = new HashMap<>();

		for (int i = 0; i < nrOfTestCases; i++) {
			String firstLine = reader.readLine();
			String[] split = firstLine.split(" ");
			int nrOfElements = Integer.parseInt(split[0]);
			int sum = Integer.parseInt(split[1]);

			String elements = reader.readLine();
			String concatenatedInput = nrOfElements + ":" + sum + ":" + elements;
			inputMap.put(i + 1, concatenatedInput);
		}

		Set<Entry<Integer, String>> entrySet = inputMap.entrySet();
		for (Entry<Integer, String> entry : entrySet) {
			// printStartAndEndIndex(entry.getKey(), entry.getValue());
			subArraySum(entry.getKey(), entry.getValue());
		}
	}

	private static int subArraySum(Integer key, String value) {
		String[] splitStrInMap = value.split(":");
		int nrOfElements = Integer.parseInt(splitStrInMap[0]);
		int sum = Integer.parseInt(splitStrInMap[1]);
		String elements = splitStrInMap[2];

		String[] elementArray = elements.split(" ");
		int curr_sum, i, j;

		// Pick a starting point
		for (i = 0; i < nrOfElements; i++) {
			curr_sum = (Integer.parseInt(elementArray[i]));

			// try all subarrays starting with 'i'
			for (j = i + 1; j <= nrOfElements; j++) {
				if (curr_sum == sum) {
					int p = j - 1;
					System.out.println("Sum found between indexes " + i + " and " + p);
					return 1;
				}
				if (curr_sum > sum || j == nrOfElements)
					break;
				curr_sum = curr_sum + Integer.parseInt(elementArray[j]);
			}
		}

		System.out.println("No subarray found");
		return 0;
	}

	// 1 2 3 7 5
	private static void printStartAndEndIndex(Integer key, String value) {
		String[] splitStrInMap = value.split(":");
		int nrOfElements = Integer.parseInt(splitStrInMap[0]);
		int sum = Integer.parseInt(splitStrInMap[1]);
		String elements = splitStrInMap[2];

		String[] elementArray = elements.split(" ");

		if (nrOfElements != elementArray.length) {
			System.out.println("Nr of Elements does not match with elements entered!");
		}

		int tempSum = 0;
		int startIndex = 0;
		int endIndex = 0;
		boolean indexesFound = false;

		for (int i = 0; i < elementArray.length && indexesFound == false; i++) {
			int number = Integer.parseInt(elementArray[i]);

			startIndex = i;
			tempSum += number;

			for (int j = i + 1; j <= elementArray.length; j++) {

				if (tempSum == sum) {
					endIndex = j;
					indexesFound = true;
					break;
				} else if (tempSum < sum) {
					tempSum = tempSum + Integer.parseInt(elementArray[j]);
				} else {
					tempSum = 0;
					break;
				}
			}
		}
		if (indexesFound) {
			System.out.println((++startIndex) + " " + endIndex);
		} else {
			System.out.println("-1");
		}
	}

}
