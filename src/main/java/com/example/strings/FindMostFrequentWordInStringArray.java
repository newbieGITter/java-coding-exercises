package com.example.strings;

import java.util.HashMap;

public class FindMostFrequentWordInStringArray {
	public static void main(String[] args) {
		String[] inputArray = {"Jason Roy", "Johny Bairstow", "Joe Root", "Joe Denly", "Joe Root", "KP", "Jos Buttler",
							"KP", "Ben Stokes", "KP", "Chris Woakes", "KP", "Joe Root"};
		countMostFrequentWord(inputArray);

	}

	private static void countMostFrequentWord(String[] inputArray) {
		HashMap<String, Integer> stringCount = new HashMap<>();
		
		for(int i = 0; i <inputArray.length; i++){
			if(stringCount.get(inputArray[i]) == null){
				stringCount.put(inputArray[i], 0);
			}
			stringCount.put(inputArray[i], stringCount.get(inputArray[i])+1);
		}

		// Now we have a map of word -> count of word. We need to get key which has maximum count & display it using 
		// Java 8 streams. 
		//TODO
		
	}
}
