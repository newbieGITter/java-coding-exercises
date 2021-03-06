package com.example.strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FindMostFrequentWordInStringArray {
	public static void main(String[] args) {
		String[] inputArray = { "Jason Roy", "Johny Bairstow", "Joe Root", "Joe Denly", "Johny Bairstow", "KP", "Jos Buttler",
				"KP", "Ben Stokes", "KP", "Chris Woakes", "Jason Roy" };
		countMostFrequentWord(inputArray);
	}

	private static void countMostFrequentWord(String[] inputArray) {
		HashMap<String, Integer> stringCount = new HashMap<>();

		for (int i = 0; i < inputArray.length; i++) {
			if (stringCount.get(inputArray[i]) == null) {
				stringCount.put(inputArray[i], 0);
			}
			stringCount.put(inputArray[i], stringCount.get(inputArray[i]) + 1);
		}
		stringCount.forEach((k, v) -> System.out.println((k + ":" + v)));

		// Now we have a map of word -> count of word. We need to get key which has maximum count & display it using Java 8 streams.
		// This worked: 
		String mostFrequentWord = stringCount.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
		System.out.println("Most frequend word in the String array is: " + mostFrequentWord);

		// Elegant and minimized approach
		System.out.println("Most frequend word is: " + Collections.max(stringCount.entrySet(), Map.Entry.comparingByValue()).getKey()); // E
	}
}
