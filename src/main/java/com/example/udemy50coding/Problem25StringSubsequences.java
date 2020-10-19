package com.example.udemy50coding;

import java.util.ArrayList;
// No clue how this works - need to check
public class Problem25StringSubsequences {

	public static void main(String[] args) {

	}

	// Time complexity: O(n.2^n)
	// Space complexity: O(n.2^n)
	static void getSubsequences(String str, int i, String subsequence, ArrayList<String> subsequences) {
		if (i == str.length()) {
			subsequences.add(subsequence);
		} else {
			getSubsequences(str, i + 1, subsequence + str.charAt(i), subsequences);
			getSubsequences(str, i + 1, subsequence, subsequences);
		}
	}

	static ArrayList<String> getSubsequences(String str) {
		ArrayList<String> subsequences = new ArrayList<>();
		getSubsequences(str, 0, "", subsequences);
		return subsequences;
	}

}
