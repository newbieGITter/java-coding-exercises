package com.example.arrays;

import java.util.Arrays;

public class RemovingDuplicatesWithoutCollectionAPI {

	public static void main(String[] args) {
		int[] inputArray = { 1, 2, 3, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 4, 5, 6, 7,
				32, 56, 6 };

		int[] arrayWithoutDuplicates = removeDuplicatesInGivenArray(inputArray);
		Arrays.stream(arrayWithoutDuplicates).forEach(s -> System.out.print(s + " "));
		System.out.println("");
		// Using Streams
		System.out.println("Using streams ... ");
		Arrays.stream(inputArray).distinct().sorted().forEach(s -> System.out.print(s + " "));
	}

	private static int[] removeDuplicatesInGivenArray(int[] inputArray) {
		Arrays.sort(inputArray);

		int[] result = new int[inputArray.length];
		int previous = inputArray[0];
		result[0] = previous;

		for (int i = 1; i < inputArray.length; i++) {
			int ch = inputArray[i];

			if (previous != ch) {
				result[i] = ch;
			}
			previous = ch;
		}
		return result;
	}

}
