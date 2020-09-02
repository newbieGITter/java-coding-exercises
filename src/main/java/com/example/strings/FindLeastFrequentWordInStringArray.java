package com.example.strings;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindLeastFrequentWordInStringArray {
	public static void main(String[] args) {
		String[] inputArray = { "Jason Roy", "Johny Bairstow", "Joe Root", "Joe Denly", "Johny Bairstow", "KP", "Jos Buttler",
				"KP", "Ben Stokes", "KP", "Chris Woakes", "Jason Roy" };
		printLeastFrequentWord(inputArray);
	}
	
	// This will return the first non-frequent(least frequent word in the String array
	private static void printLeastFrequentWord(String[] inputArray) {
		HashMap<String, Integer> stringCount = new LinkedHashMap<>();

		for (int i = 0; i < inputArray.length; i++) {
			if (stringCount.get(inputArray[i]) == null) {
				stringCount.put(inputArray[i], 0);
			}
			stringCount.put(inputArray[i], stringCount.get(inputArray[i]) + 1);
		}
		stringCount.forEach((k, v) -> System.out.println((k + ":" + v)));

		// Now we have a map of word -> count of word. We need to get key which has maximum count & display it using Java 8 streams.
		// This worked: 
		String leastFrequentWord = stringCount.entrySet().stream().min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
		System.out.println("Least frequent word in the String array is: " + leastFrequentWord);

		// Elegant and minimized approach
		System.out.println("Least frequent word is: " + Collections.min(stringCount.entrySet(), Map.Entry.comparingByValue()).getKey()); // E
	}
}
