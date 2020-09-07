package com.example.booking;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1Solution {

	// To find out maximum occuring char in string. 
	// If there are two characters which have occured same nr of times, then return one which appears first in given string
	// For instance: in string 'zaabbabcczz' - all characters a, b, c and z have appeared thrice. 
	//So in this case, return z as it appears earlier.
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			String A = sc.next();
			System.out.println("Given string is: " + A);
			System.out.println("Maximum occuring character is: " + getMaximumOccuringChar(A));
		}
	}

	private static Character getMaximumOccuringChar(String a) {
		char[] charArray = a.toCharArray();
		Map<Character, Integer> charMap = new LinkedHashMap<>();

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
