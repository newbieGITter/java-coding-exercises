package com.example.udemy50coding;

import java.util.HashMap;
import java.util.Map;

// Given a string str, create a function that returns the first repeating character.
public class Problem2FindFirstRepeatingCharacterInString {
	// Input: str = "inside code"
	// Output: 'i'

	// Input: str = "programming"
	// Output: 'r'

	// Input: str = "abcd"
	// Output: '\0'
	public static void main(String[] args) {
		String str = "abcd";
		char repeatingCharacter = bruteForceSolution(str);
		System.out.println("Repeating character using Brute force solution: " + repeatingCharacter);
		
		repeatingCharacter = usingHashMap(str);
		System.out.println("Repeating character using Map solution: " + repeatingCharacter);
	}

	// Time complexity: O(n)
	// Space complexity: O(n)
	private static char usingHashMap(String str) {
		Map<Character, Boolean> visited = new HashMap<>();
		char[] charArray = str.toCharArray();

		for (char ch : charArray) {
			if (visited.containsKey(ch))
				return ch;
			else
				visited.put(ch, true);
		}
		return '\0';
	}
	
	// Time complexity: O(n²)
	// Space complexity: O(1)
	private static char bruteForceSolution(String str) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					return str.charAt(i);
				}
			}
		}
		return '\0';
	}
}
