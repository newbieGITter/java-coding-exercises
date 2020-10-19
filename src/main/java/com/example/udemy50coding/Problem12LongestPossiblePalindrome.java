package com.example.udemy50coding;

public class Problem12LongestPossiblePalindrome {

	public static void main(String[] args) {
		String str1 = "abbaba";
		// System.out.println(longestPalindrome(str1));
		// output: 5 Longest palindrome that can be made is: abbba or baaab so length is
		// 5.

		str1 = "abbaaa";
		// System.out.println(longestPalindrome(str1));
		// Output: 6. Longest palindrome will be: baaaab so length is 6

		str1 = "abbabab";
		// System.out.println(longestPalindrome(str1));
		// Output: 7. Longest palindrome will be: abbabba or bbaaabb so length is 7

		str1 = "abdccdceeebebc"; // a: 1; b: 3; c: 4; d:2; e: 4
		System.out.println(longestPalindrome(str1));
		// output: 13.
		// Explanation: one of the longest palindromes that can be made is
		// "eedccbabccdee", its length is 13
	}

	// Time complexity: O(n)
	// Space complexity: O(1)
	private static int longestPalindrome(String str) {
		int[] occurences = new int[128];
		for (char letter : str.toCharArray()) {
			occurences[(int) letter]++;
		}
		int length = 0;
		for (int occu : occurences) {
			length += occu % 2 == 0 ? occu : occu - 1;
		}

		if (length < str.length())
			length++;

		return length;
	}

}
