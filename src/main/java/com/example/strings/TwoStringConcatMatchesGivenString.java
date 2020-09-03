package com.example.strings;

public class TwoStringConcatMatchesGivenString {

	public static void main(String[] args) {
		String str = "GeeksforGeeks";
		String a = "Geeksfo";
		String b = "rGeeks";

		if (checkString(str, a, b)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	// Function that returns true
	// if str = a + b or str = b + a
	private static boolean checkString(String str, String a, String b) {
		if (str.length() != a.length() + b.length()) {
			return false;
		}

		if (startsWith(str, a)) {
			if (endsWith(str, b)) {
				return true;
			}
		}

		if (startsWith(str, b)) {
			if (endsWith(str, a)) {
				return true;
			}
		}
		return false;
	}

	private static boolean endsWith(String str, String suffix) {
		for (int i = str.length() - 1, j = suffix.length() - 1; i > 0 && j > 0; i--, j--) {
			if (str.charAt(i) != suffix.charAt(j)) {
				return false;
			}
		}
		return true;
	}

	private static boolean startsWith(String str, String prefix) {
		for (int i = 0; i < prefix.length(); i++) {
			if (str.charAt(i) != prefix.charAt(i)) {
				return false;
			}
		}
		return true;
	}

}
