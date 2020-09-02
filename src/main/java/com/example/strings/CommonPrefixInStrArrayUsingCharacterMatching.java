package com.example.strings;

public class CommonPrefixInStrArrayUsingCharacterMatching {

	public static void main(String[] args) {
		String arr[] = { "geeksforgeeks", "geeks", "geek", "geekzer" };
		int n = arr.length;

		String ans = commonPrefix(arr, n);

		if (ans.length() > 0) {
			System.out.println("The longest common prefix is " + ans);
		} else {
			System.out.println("There is no common prefix");
		}
	}

	// A Function that returns the longest common prefix
	// from the array of strings
	static String commonPrefix(String arr[], int n) {
		int minlen = findMinLength(arr, n);

		String result = ""; // Our resultant string
		char current; // The current character

		for (int i = 0; i < minlen; i++) {
			// Current character (must be same
			// in all strings to be a part of
			// result)
			current = arr[0].charAt(i);

			for (int j = 1; j < n; j++) {
				if (arr[j].charAt(i) != current) {
					return result;
				}
			}

			// Append to result
			result += (current);
		}

		return (result);
	}
	
	// A Function to find the string having the minimum
		// length and returns that length
		static int findMinLength(String arr[], int n) {
			int min = arr[0].length();

			for (int i = 1; i < n; i++) {
				if (arr[i].length() < min) {
					min = arr[i].length();
				}
			}

			return (min);
		}

}
