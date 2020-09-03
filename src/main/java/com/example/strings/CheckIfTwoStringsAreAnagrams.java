package com.example.strings;

import java.util.Scanner;

public class CheckIfTwoStringsAreAnagrams {

	static boolean isAnagram(String A, String B) {
		// Complete the function
		if (A == null || A.length() != B.length()) {
			return false;
		}

		char[] characters = A.toLowerCase().toCharArray();
		StringBuilder sb = new StringBuilder(B.toLowerCase());

		for (char ch : characters) {
			int index = sb.indexOf(String.valueOf(ch));
			if (index == -1) {
				return false;
			}
			sb.delete(index, index + 1);
		}
		return true;
	}

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)){
			String A = sc.next();
			String B = sc.next();
			boolean ret = isAnagram(A, B);
			if (ret)
				System.out.println("Anagrams");
			else
				System.out.println("Not Anagrams");
		}

	}

}
