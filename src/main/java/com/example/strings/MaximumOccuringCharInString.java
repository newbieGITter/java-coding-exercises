package com.example.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaximumOccuringCharInString {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String A = sc.next();
			System.out.println("Given string is: " + A);
			System.out.println("Maximum occuring character is: " + getMaximumOccuringChar(A));
		}
	}

	private static Character getMaximumOccuringChar(String a) {
		char[] charArray = a.toCharArray();
		Map<Character, Integer> charMap = new HashMap<>();

		for (int i = 0; i < charArray.length; i++) {
			if (charMap.containsKey(charArray[i])) {
				charMap.put(charArray[i], charMap.get(charArray[i]) + 1);
			} else {
				charMap.put(charArray[i], 1);
			}
		}
		charMap.entrySet().stream().forEach(System.out::print);
		System.out.println(" ");
		return charMap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
	}

}
