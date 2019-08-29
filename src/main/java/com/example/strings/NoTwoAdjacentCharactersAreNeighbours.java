package com.example.strings;

import java.util.Arrays;

public class NoTwoAdjacentCharactersAreNeighbours {

	public static void main(String[] args) {
		String str = "aabcd";

		rearrange(str);
	}

	private static void rearrange(String str) {
		// First lets store odd and even characters
		String odd = "";
		String even = "";

		// Traverse through the string
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) % 2 == 0) {
				even += str.charAt(i);
				System.out.println("even:" + even);
			} else {
				odd += str.charAt(i);
				System.out.println("odd: " + odd);
			}
		}

		// Sort both the string
		odd = sort(odd);
		even = sort(even);

		if (check(odd + even)) {
			System.out.println(odd + even);
		} else if (check(even + odd)) {
			System.out.println(even + odd);
		} else {
			System.out.println(-1);
		}

	}

	private static boolean check(String s) {
		for (int i = 0; i + 1 < s.length(); ++i) {
			if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 1) {
				return false;
			}
		}
		return true;
	}

	private static String sort(String str) {
		char[] strArray = str.toCharArray();

		Arrays.sort(strArray);

		return new String(strArray);
	}
}
