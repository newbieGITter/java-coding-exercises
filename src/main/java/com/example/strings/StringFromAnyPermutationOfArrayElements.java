package com.example.strings;

import java.util.Arrays;

public class StringFromAnyPermutationOfArrayElements {

	public static void main(String[] args) {
		String str = "saahas";
		String[] arr = { "saa", "aaa", "hsa", "sss", "haa" };

		if (isStringPossibleFromArrayElements(str, arr)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

	private static boolean isStringPossibleFromArrayElements(String str, String[] arr) {
		// Sort the given string
		str = sortString(str);

		// Select two strings at a time from given vector
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {

				// Get the concatenated string
				String temp = arr[i] + arr[j];

				// Sort the resultant string
				temp = sortString(temp);

				// If the resultant string is equal
				// to the given string str
				if (temp.compareTo(str) == 0) {
					return true;
				}
			}
		}

		// No valid pair found
		return false;
	}

	// Method to sort a string alphabetically
	public static String sortString(String inputString) {
		// convert input string to char array
		char tempArray[] = inputString.toCharArray();

		// sort tempArray
		Arrays.sort(tempArray);

		// return new sorted string
		return new String(tempArray);
	}
}
