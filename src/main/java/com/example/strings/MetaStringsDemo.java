package com.example.strings;

public class MetaStringsDemo {
	/*
	 * Input : str1 = "geeks" 
        	   str2 = "keegs"
		Output : Yes
		By just swapping 'k' and 'g' in any of string, 
		both will become same.
	 */
	// Meta strings are the strings which can be made equal by exactly one swap
	// in any of the strings. Equal string are not considered here as Meta
	// strings.
	
	public static void main(String args[]) {
		String str1 = "saahas";
		String str2 = "asshaa";

		System.out.println(areMetaStrings(str1, str2) ? "Yes" : "No");
	}

	private static boolean areMetaStrings(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();

		if (len1 != len2) {
			return false;
		}

		// To store indexes of previously mismatched
		// characters
		int prev = -1, curr = -1;

		int count = 0;

		for (int i = 0; i < len1; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				count++;

				if (count > 2) {
					return false;
				}

				prev = curr;
				curr = i;
			}
		}

		return count == 2 && str1.charAt(prev) == str2.charAt(curr) && str1.charAt(curr) == str2.charAt(prev);
	}
}
