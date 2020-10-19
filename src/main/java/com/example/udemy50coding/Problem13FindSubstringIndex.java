package com.example.udemy50coding;

public class Problem13FindSubstringIndex {

	public static void main(String[] args) {
		// Input: str1 = inside; str2 = side ;
		// Output: 2
		String str1 = "inside";
		String str2 = "ide";

		// Input: str1 = inside; str2 = in ;
		// Output: 0
		//String str1 = "inside";
		//String str2 = "in";

		// Input: str1 = inside; str2 = code ;
		// Output: -1
		//String str1 = "inside";
		//String str2 = "code";

		System.out.println(substrIndex(str1, str2));
	}

	// Time complexity: O(nm)
	// Space complexity: O(1)
	private static int substrIndex(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();

		for (int i = 0; i <= n - m; i++) {
			boolean found = true;

			for (int j = 0; j < m; j++) {
				if (str1.charAt(i + j) != str2.charAt(j)) {
					found = false;
					break;
				}
			}
			if (found)
				return i;
		}
		return -1;
	}

}
